package com.example.springresrfulprcatice.service;

import com.example.springresrfulprcatice.controller.dto.request.CreateOrderRequest;
import com.example.springresrfulprcatice.controller.dto.request.UpdateOrderRequest;
import com.example.springresrfulprcatice.model.Entity.Order;
import com.example.springresrfulprcatice.model.MealRepository;
import com.example.springresrfulprcatice.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    List<Order> orderList;

    /**
     * 找到全部的 orders
     */
    public List<Order> getAllOrders() {

        List<Order> response = orderRepository.findAll();

        return response;
    }

    /**
     * 藉由 id 找到特定的 Order
     * @param id Order 的 id (key)
     */
    public Order getOrderById(int id) {

        Order response = orderRepository.findById(id);

        return response;
    }

    /**
     * 藉由 seq 找到特定的 Order
     * @param seq Order 的 seq(訂單編號)
     */
    public List<Order> getOrderBySeq(String seq) {

        List<Order> response = orderRepository.findAllBySeq(seq);

        return response;
    }

    /**
     * 新增一筆 Order
     */
    public String createOrder(CreateOrderRequest request) {

        //新增一個空的 order 的 Entity
        Order order = new Order();

        int createId = request.getId();
        if(null != orderRepository.findById(createId)){
            return "Had This OrderId";
        }

        //確認 Meal 是否存在
        if(checkMealId(request.getMealId()) == false){
            return "Without This Meal";
        };

        //確認同筆訂單 Meal 是否重複
        int checkOrder = checkOrder(request.getSeq(),request.getMealId());
        if(checkOrder != 0){
            return "Order " + request.getSeq() + " Have This Meal At Id " + checkOrder;
        };

        //放入資料: user 從 request 拿資料
        order.setId(request.getId());
        order.setSeq(request.getSeq());
        order.setWaiter(request.getWaiter());
        order.setMealId(request.getMealId());
        order.setQuan(request.getQuan());

        orderRepository.save(order);

        totalPrice(request.getSeq());

        return "Save Success";
    }

    /**
     * 用 id 找到需要更新的 Order
     */
    public String updateOrder(int id, UpdateOrderRequest request) {

        //確認有沒有這筆資料
        Order order = orderRepository.findById(id);

        if(null == order){
            return "Not Found Order";
        }

        //確認 Meal 是否存在
        if(checkMealId(request.getMealId()) == false){
            return "Without This Meal";
        };

        //確認同筆訂單 Meal 是否重複
        int checkMeal = checkOrder(request.getSeq(),request.getMealId());

        if(checkMeal != 0 && (order.getId() != checkMeal)){
            return "Order " + request.getSeq() + " Have This Meal At Id " + checkMeal;
        };

        order.setSeq(request.getSeq());
        order.setWaiter(request.getWaiter());
        order.setMealId(request.getMealId());
        order.setQuan(request.getQuan());

        //存入DB
        orderRepository.save(order);

        totalPrice(request.getSeq());

        //告訴 Controller 已存入 DB
        return "Update Success";
    }

    /**
     * 用 id 找到要刪除的 Order
     */
    public String deleteOrderById(int id) {

        Order order = orderRepository.findById(id);

        if(null == order){
            return "Not Found Order";
        }

        Long count = orderRepository.deleteById(id);

        totalPrice(order.getSeq());

        return "Delete Success";

    }


    /**
     * 計算每筆訂單的總金額
     */
    public void totalPrice(String Seq){

        int totalPrice = 0;

        //金額加總
        for(Order order : orderRepository.findAllBySeq(Seq)) {

            int quan = order.getQuan();
            int mealPrice = (mealRepository.findById(order.getMealId())).getPrice();

            totalPrice += mealPrice * quan;

        }
        //存入資料庫
        for(Order order : orderRepository.findAllBySeq(Seq)){

            order.setTotalPrice(totalPrice);

            orderRepository.save(order);

        }
    }


    /**
     * 確認輸入的 Meal 是否存在
     */
    public boolean checkMealId(int id){

        if(null == mealRepository.findById(id)){
            return false;
        }
        return true;
    }

    /**
     * 確認同筆訂單是否有相同 Meal
     */
    public int checkOrder(String Seq,int id){

        int check = 0;

        for(Order order : orderRepository.findAllBySeq(Seq)){

            if(order.getMealId() == id){
                check = order.getId();
            }
        }
        return check;
    }


}

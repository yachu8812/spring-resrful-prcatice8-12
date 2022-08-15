package com.example.springresrfulprcatice.controller;

import com.example.springresrfulprcatice.controller.dto.request.CreateOrderRequest;
import com.example.springresrfulprcatice.controller.dto.request.UpdateOrderRequest;
import com.example.springresrfulprcatice.controller.dto.response.StatusResponse;
import com.example.springresrfulprcatice.model.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springresrfulprcatice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
//http://localhost:8080/order

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {

        List<Order> response = orderService.getAllOrders();

        return response;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {

        Order response = orderService.getOrderById(id);

        return response;
    }

    @GetMapping("/seq")
    public List<Order> getOrderBySeq(@RequestParam String seq) {

        List<Order> response = orderService.getOrderBySeq(seq);

        return response;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest order) {

        String response = orderService.createOrder(order);

        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest order) {

        String response = orderService.updateOrder(id, order);

        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteOrder(@PathVariable int id) {

        String response = orderService.deleteOrderById(id);

        return new StatusResponse(response);
    }


}

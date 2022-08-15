package com.example.springresrfulprcatice.model;

import com.example.springresrfulprcatice.model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(int id);

    List<Order> findAllBySeq(String seq);

    Long deleteById(int id);



}

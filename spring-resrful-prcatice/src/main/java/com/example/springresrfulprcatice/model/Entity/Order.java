package com.example.springresrfulprcatice.model.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column
    private int id;

    @Column
    private String seq;

    @Column
    private int totalPrice;

    @Column
    private String waiter;

    @Column
    private int mealId;     //餐點編號

    @Column
    private int quan;   //餐點數量



}

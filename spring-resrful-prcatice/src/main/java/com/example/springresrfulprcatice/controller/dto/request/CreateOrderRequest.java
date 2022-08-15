package com.example.springresrfulprcatice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {

    private int id;
    private String seq;
    private String waiter;
    private int mealId;
    private int quan;


}

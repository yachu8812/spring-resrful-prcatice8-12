package com.example.springresrfulprcatice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateOrderRequest {

    //通過 Id 知道要更新的資料
    private String seq;
    private String waiter;
    private int mealId;
    private int quan;
}

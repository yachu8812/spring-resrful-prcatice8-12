package com.example.springresrfulprcatice.controller;

import com.example.springresrfulprcatice.model.Entity.Meal;
import com.example.springresrfulprcatice.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meal")
//http://localhost:8080/meal
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping()
    public List<Meal> getAllMeals() {

        List<Meal> response = mealService.getAllMeals();

        return response;
    }

}

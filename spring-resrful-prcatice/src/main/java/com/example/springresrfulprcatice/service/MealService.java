package com.example.springresrfulprcatice.service;

import com.example.springresrfulprcatice.model.Entity.Meal;
import com.example.springresrfulprcatice.model.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    //全部 Order
    public List<Meal> getAllMeals() {

        List<Meal> response = mealRepository.findAll();

        return response;
    }
}

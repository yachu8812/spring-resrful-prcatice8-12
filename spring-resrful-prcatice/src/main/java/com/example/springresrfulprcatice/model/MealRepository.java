package com.example.springresrfulprcatice.model;

import com.example.springresrfulprcatice.model.Entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    Meal findById(int id);
}

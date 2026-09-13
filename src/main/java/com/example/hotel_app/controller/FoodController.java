package com.example.hotel_app.controller;

import com.example.hotel_app.model.FoodItem;
import com.example.hotel_app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodService.getAllFoodItems();
    }

    @PostMapping
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
        return foodService.saveFoodItem(foodItem);
    }
}
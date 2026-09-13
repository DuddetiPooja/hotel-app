package com.example.hotel_app.service;

import com.example.hotel_app.model.FoodItem;
import com.example.hotel_app.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }

    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodRepository.save(foodItem);
    }
}
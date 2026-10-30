package com.example.hotel_app.service;

import com.example.hotel_app.exception.ResourceNotFoundException;
import com.example.hotel_app.model.FoodItem;
import com.example.hotel_app.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // Preserved original method
    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }

    // Preserved original method
    public FoodItem saveFoodItem(FoodItem foodItem) {
        return foodRepository.save(foodItem);
    }

    // NEW: Get food item by ID
    public FoodItem getFoodItemById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food item not found with ID: " + id));
    }

    // NEW: Update food item
    public FoodItem updateFoodItem(Long id, FoodItem updated) {
        FoodItem existing = getFoodItemById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setCategory(updated.getCategory());
        return foodRepository.save(existing);
    }

    // NEW: Delete food item
    public void deleteFoodItem(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete: Food item not found with ID: " + id);
        }
        foodRepository.deleteById(id);
    }
}

package com.example.hotel_app.controller;

import com.example.hotel_app.model.FoodItem;
import com.example.hotel_app.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Preserved original endpoint
    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodService.getAllFoodItems();
    }

    // Preserved original endpoint
    @PostMapping
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {
        return foodService.saveFoodItem(foodItem);
    }

    // NEW: GET /api/food/{id}
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodItemById(id));
    }

    // NEW: PUT /api/food/{id}
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(foodService.updateFoodItem(id, foodItem));
    }

    // NEW: DELETE /api/food/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        foodService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
}

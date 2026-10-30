package com.example.hotel_app.dto;

import com.example.hotel_app.model.RoomType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RoomDTO {

    private Long id;

    @NotBlank(message = "Room number cannot be blank")
    private String roomNumber;

    @NotNull(message = "Room type is required (SINGLE, DOUBLE, DELUXE, SUITE, PRESIDENTIAL)")
    private RoomType roomType;

    @Positive(message = "Price per night must be greater than zero")
    private double pricePerNight;

    @Min(value = 1, message = "Room capacity must be at least 1 person")
    private int capacity;

    private boolean isAvailable = true;

    private String description;

    // Constructors
    public RoomDTO() {
    }

    public RoomDTO(Long id, String roomNumber, RoomType roomType, double pricePerNight, int capacity, boolean isAvailable, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

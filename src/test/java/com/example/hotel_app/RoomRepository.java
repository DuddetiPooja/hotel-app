package com.example.hotel_app.repository;

import com.example.hotel_app.model.Room;
import com.example.hotel_app.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // Find room by its unique room number
    Optional<Room> findByRoomNumber(String roomNumber);

    // Check if a room number already exists
    boolean existsByRoomNumber(String roomNumber);

    // Find all currently available rooms
    List<Room> findByIsAvailable(boolean isAvailable);

    // Filter rooms by category/type
    List<Room> findByRoomType(RoomType roomType);

    // Filter rooms by minimum guest capacity
    List<Room> findByCapacityGreaterThanEqual(int capacity);
}

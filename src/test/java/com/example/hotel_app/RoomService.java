package com.example.hotel_app.service;

import com.example.hotel_app.dto.RoomDTO;
import com.example.hotel_app.exception.ResourceNotFoundException;
import com.example.hotel_app.model.Room;
import com.example.hotel_app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // Retrieve all rooms
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Retrieve only available rooms
    public List<RoomDTO> getAvailableRooms() {
        return roomRepository.findByIsAvailable(true)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Retrieve a room by ID
    public RoomDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));
        return convertToDTO(room);
    }

    // Create room with uniqueness check
    public RoomDTO createRoom(RoomDTO dto) {
        if (roomRepository.existsByRoomNumber(dto.getRoomNumber())) {
            throw new IllegalArgumentException("Room number '" + dto.getRoomNumber() + "' already exists!");
        }

        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setRoomType(dto.getRoomType());
        room.setPricePerNight(dto.getPricePerNight());
        room.setCapacity(dto.getCapacity());
        room.setAvailable(dto.isAvailable());
        room.setDescription(dto.getDescription());

        Room saved = roomRepository.save(room);
        return convertToDTO(saved);
    }

    // Update existing room
    public RoomDTO updateRoom(Long id, RoomDTO dto) {
        Room existing = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));

        if (!existing.getRoomNumber().equalsIgnoreCase(dto.getRoomNumber()) &&
                roomRepository.existsByRoomNumber(dto.getRoomNumber())) {
            throw new IllegalArgumentException("Room number '" + dto.getRoomNumber() + "' is already in use!");
        }

        existing.setRoomNumber(dto.getRoomNumber());
        existing.setRoomType(dto.getRoomType());
        existing.setPricePerNight(dto.getPricePerNight());
        existing.setCapacity(dto.getCapacity());
        existing.setAvailable(dto.isAvailable());
        existing.setDescription(dto.getDescription());

        Room updated = roomRepository.save(existing);
        return convertToDTO(updated);
    }

    // Toggle availability
    public RoomDTO toggleAvailability(Long id, boolean available) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + id));
        room.setAvailable(available);
        return convertToDTO(roomRepository.save(room));
    }

    // Delete room
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete: Room not found with ID: " + id);
        }
        roomRepository.deleteById(id);
    }

    // Convert Entity to DTO
    public RoomDTO convertToDTO(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getPricePerNight(),
                room.getCapacity(),
                room.isAvailable(),
                room.getDescription()
        );
    }
}

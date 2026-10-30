package com.example.hotel_app.service;

import com.example.hotel_app.exception.ResourceNotFoundException;
import com.example.hotel_app.model.TableEntity;
import com.example.hotel_app.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    // Preserved original method
    public List<TableEntity> getAllTables() {
        return tableRepository.findAll();
    }

    // Preserved original method
    public TableEntity saveTable(TableEntity table) {
        return tableRepository.save(table);
    }

    // NEW: Get table by ID
    public TableEntity getTableById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with ID: " + id));
    }

    // NEW: Update table
    public TableEntity updateTable(Long id, TableEntity updated) {
        TableEntity existing = getTableById(id);
        existing.setTableNumber(updated.getTableNumber());
        existing.setCapacity(updated.getCapacity());
        existing.setReserved(updated.isReserved());
        return tableRepository.save(existing);
    }

    // NEW: Delete table
    public void deleteTable(Long id) {
        if (!tableRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete: Table not found with ID: " + id);
        }
        tableRepository.deleteById(id);
    }
}

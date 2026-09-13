package com.example.hotel_app.service;

import com.example.hotel_app.model.TableEntity;
import com.example.hotel_app.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<TableEntity> getAllTables() {
        return tableRepository.findAll();
    }

    public TableEntity saveTable(TableEntity table) {
        return tableRepository.save(table);
    }
}
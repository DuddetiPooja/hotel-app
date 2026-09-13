package com.example.hotel_app.controller;

import com.example.hotel_app.model.TableEntity;
import com.example.hotel_app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping
    public List<TableEntity> getAllTables() {
        return tableService.getAllTables();
    }

    @PostMapping
    public TableEntity createTable(@RequestBody TableEntity table) {
        return tableService.saveTable(table);
    }
}
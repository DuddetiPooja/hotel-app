package com.example.hotel_app.controller;

import com.example.hotel_app.model.TableEntity;
import com.example.hotel_app.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "*")
public class TableController {

    @Autowired
    private TableService tableService;

    // Preserved original endpoint
    @GetMapping
    public List<TableEntity> getAllTables() {
        return tableService.getAllTables();
    }

    // Preserved original endpoint
    @PostMapping
    public TableEntity createTable(@RequestBody TableEntity table) {
        return tableService.saveTable(table);
    }

    // NEW: GET /api/tables/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TableEntity> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableById(id));
    }

    // NEW: PUT /api/tables/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TableEntity> updateTable(@PathVariable Long id, @RequestBody TableEntity table) {
        return ResponseEntity.ok(tableService.updateTable(id, table));
    }

    // NEW: DELETE /api/tables/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}

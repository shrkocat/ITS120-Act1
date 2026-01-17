package com.santeco.pss.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import com.santeco.pss.entity.Inventory;
import com.santeco.pss.repository.InventoryRepository;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;
    @PostMapping("/seed")
    public ResponseEntity<String> seedInventory(@RequestBody List<Inventory> items) {
        inventoryRepository.saveAll(items);
        return ResponseEntity.ok("Inventory seeded/updated successfully!");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(inventoryRepository.findAll());
    }
}

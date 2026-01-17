package com.santeco.pss.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.santeco.pss.entity.Inventory;
import com.santeco.pss.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional
    public void reduceStock(int productId, int quantity) {
        Inventory inv = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        int newStock = inv.getStock() - quantity;
        if (newStock < 0) {
            throw new RuntimeException("Insufficient stock for product: " + productId);
        }

        inv.setStock(newStock);
        inventoryRepository.save(inv);
    }
}

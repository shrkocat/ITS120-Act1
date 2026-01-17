package com.santeco.pss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.santeco.pss.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}

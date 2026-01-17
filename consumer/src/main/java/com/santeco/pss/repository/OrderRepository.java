package com.santeco.pss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.santeco.pss.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findById(Long id);
}
package com.santeco.pss.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.santeco.pss.payload.Order;
import com.santeco.pss.service.InventoryService;

@Service
@RequiredArgsConstructor
public class InventoryKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryKafkaConsumer.class);

    private final InventoryService inventoryService;

    @KafkaListener(topics = "pss_order", groupId = "inventory-service")
    public void consume(Order order) {
        LOGGER.info("Updating inventory for order id={}", order.getId());

        order.getItems().forEach(item -> {
            try {
                inventoryService.reduceStock(item.getProductId(), item.getQuantity());
                LOGGER.info("Product {} reduced by {}", item.getProductId(), item.getQuantity());
            } catch (RuntimeException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}

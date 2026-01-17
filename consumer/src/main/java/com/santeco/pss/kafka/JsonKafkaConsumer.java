package com.santeco.pss.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.santeco.pss.payload.Order;
import com.santeco.pss.service.OrderService;

@Service
@RequiredArgsConstructor
public class JsonKafkaConsumer {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JsonKafkaConsumer.class);

    private final OrderService orderService;

    @KafkaListener(topics = "pss_order", groupId = "order-service")
    public void consume(Order order) {
        LOGGER.info("Received order id={}", order.getId());
        orderService.saveOrder(order);
    }
}

package com.santeco.pss.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.santeco.pss.entity.OrderEntity;
import com.santeco.pss.entity.OrderItemEntity;
import com.santeco.pss.payload.Order;
import com.santeco.pss.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // Kafka consumer calls this
    @Transactional
    public void saveOrder(Order order) {

        OrderEntity orderEntity = OrderEntity.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .totalAmount(order.getTotalAmount())
                .orderTimestamp(order.getOrderTimestamp())
                .build();

        var items = order.getItems().stream()
                .map(item -> OrderItemEntity.builder()
                        .productId(item.getProductId())
                        .itemName(item.getItemName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())
                        .uom(item.getUom())
                        .order(orderEntity)
                        .build())
                .collect(Collectors.toList());

        orderEntity.setItems(items);
        orderRepository.save(orderEntity);
    }

    // Controller calls this
    @Transactional(readOnly = true)
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // Controller calls this
    @Transactional(readOnly = true)
    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + id));
    }
}

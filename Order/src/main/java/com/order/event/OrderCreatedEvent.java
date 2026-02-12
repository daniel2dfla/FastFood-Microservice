package com.order.event;

import com.order.entity.OrderEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderCreatedEvent (
        UUID orderId,
        UUID customerId,
        BigDecimal totalAmount,
        LocalDateTime createdAt
){
    public static OrderCreatedEvent from(OrderEntity entity) {
        return new OrderCreatedEvent(
                entity.getId(),
                entity.getCustomerId(),
                entity.getTotalAmount(),
                entity.getCreatedAt()
        );
    }
}

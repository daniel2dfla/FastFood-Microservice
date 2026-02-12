package com.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPostDTO {

        private UUID orderId;

        private UUID customerId;

        private String customer_name;

        private String restaurant_name;

        private BigDecimal total_value;

        private OrderStatus status;

        private Instant createdAt;
}

package com.order.repository;

import com.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderPostRepository extends JpaRepository<OrderEntity, UUID> {
}

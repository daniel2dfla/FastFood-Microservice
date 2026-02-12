package com.order.service;

import com.order.dto.OrderPostDTO;
import com.order.dto.OrderStatus;
import com.order.entity.OrderEntity;
import com.order.event.OrderCreatedEvent;
import com.order.message.OrderProducer;
import com.order.repository.OrderPostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderPostServiceImp implements OrderPostService{

    @Autowired
    private final OrderProducer orderProducer;

    @Autowired
    private final OrderPostRepository orderPostRepository;

    @Override
    @Transactional
    public void createOrder(OrderPostDTO orderPostDTO){

        OrderEntity entity = dtoToEntity(orderPostDTO);

        OrderEntity saved = orderPostRepository.save(entity);

        OrderCreatedEvent event = OrderCreatedEvent.from(saved);

        orderProducer.send(event);
    }

    public OrderEntity dtoToEntity(OrderPostDTO dto) {
        return OrderEntity.builder()
                .customerId(dto.getCustomerId())
                .totalAmount(dto.getTotal_value())
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();
    }
}

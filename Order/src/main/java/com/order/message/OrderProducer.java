package com.order.message;

import com.order.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class OrderProducer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public OrderProducer(
            KafkaTemplate<String, byte[]> kafkaTemplate,
            ObjectMapper objectMapper
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(OrderCreatedEvent event) {

        try {
            byte[] payload = objectMapper.writeValueAsBytes(event);

            kafkaTemplate.send(
                    "order-status-events",
                    payload
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error serializing event.", e);
        }
    }
}

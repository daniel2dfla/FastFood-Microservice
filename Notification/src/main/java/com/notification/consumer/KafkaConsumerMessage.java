package com.notification.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import tools.jackson.databind.ObjectMapper;

public class KafkaConsumerMessage {

    private final ObjectMapper objectMapper;

    public KafkaConsumerMessage(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @KafkaListener(topics = "order-status-events", groupId = "notification-group")
    public void listening(byte[] payload) {
        try{
            LOG.info("Received payload: {}", new String(payload));


        } catch (Exception e) {
            LOG.error("Error processing Kafka message", e);
            throw new RuntimeException(e);
        }
    }
}

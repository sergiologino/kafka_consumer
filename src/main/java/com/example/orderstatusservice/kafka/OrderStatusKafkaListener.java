package com.example.orderstatusservice.kafka;


import com.example.event.OrderStatusEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderStatusKafkaListener {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public OrderStatusKafkaListener(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "order-topic", groupId = "orderstatus_group")
    public void listenOrder(ConsumerRecord<String, String> record) throws JsonProcessingException {
        String orderEventJson = record.value();
        OrderStatusEvent orderEvent = objectMapper.readValue(orderEventJson, OrderStatusEvent.class);
        String statusEvent = objectMapper.writeValueAsString(orderEvent);
        kafkaTemplate.send("order-status-topic", statusEvent);
    }
}
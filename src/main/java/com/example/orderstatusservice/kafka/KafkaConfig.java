package com.example.orderstatusservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic orderTopic() {
        return new NewTopic("order-topic", 1, (short) 1);
    }

    @Bean
    public NewTopic orderStatusTopic() {
        return new NewTopic("order-status-topic", 1, (short) 1);
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

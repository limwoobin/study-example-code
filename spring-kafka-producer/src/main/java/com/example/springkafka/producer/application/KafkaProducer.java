package com.example.springkafka.producer.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    @Value("${spring.kafka.topics.exam}")
    private String examTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void messageSend() {
        log.debug("kafka producer : {}", "test123");
        kafkaTemplate.send(examTopic, "test123");
    }
}

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
    @Value("${spring.kafka.producer.topics.exam}")
    private String examTopic;

    @Value("${spring.kafka.producer.topics.exam2}")
    private String exam2Topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Object> jsonKafkaTemplate;

    public void sendMessage(String message) {
        log.info("kafka producer : {}", message);
        kafkaTemplate.send(examTopic, message);
    }

    public void sendJsonMessage(String message) {
        TestVO jsonMessage = new TestVO(message, 15);

        log.info("kafka json producer : {}", jsonMessage);
        jsonKafkaTemplate.send(exam2Topic, jsonMessage);
    }
}

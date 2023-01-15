package com.example.springkafkaconsumer.consumer.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topic.exam}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(@Payload String message, Acknowledgment ack) {
        log.info("consume message {} ", message);
        ack.acknowledge();
    }
}

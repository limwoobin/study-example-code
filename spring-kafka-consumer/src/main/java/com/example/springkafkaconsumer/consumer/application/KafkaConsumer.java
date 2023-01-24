package com.example.springkafkaconsumer.consumer.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(
            topics = "${spring.kafka.topics.exam}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "containerFactory",
            errorHandler = "kafkaErrorHandler"
    )
    public void consume(@Payload String message, Acknowledgment ack) {
        log.info("consume message {} ", message);

        if (true) {
            throw new RuntimeException("error test");
        }

        ack.acknowledge();
    }

    @KafkaListener(
            topics = "${spring.kafka.topics.exam2}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "jsonContainerFactory"
    )
    public void jsonConsume(@Payload TestVO testVO, Acknowledgment ack) {
        log.info("jsonConsume message {} ", testVO);
        ack.acknowledge();
    }

    @KafkaListener(
            topics = "${spring.kafka.topics.exam3}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "jsonContainerFactory"
    )
    public void jsonConsume2(@Payload TestVO testVO, @Headers MessageHeaders messageHeaders, Acknowledgment ack) {
        log.info("json Consumer message {} {}",
            kv("message", testVO),
            kv("headers", messageHeaders)
        );

        ack.acknowledge();
    }

    @KafkaListener(
            topics = "${spring.kafka.topics.exam4}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "batchContainerFactory"
    )
    public void batchConsumer(@Payload List<TestVO> list, @Headers MessageHeaders messageHeaders) {
        log.info("batch Consumer message {} {}",
            kv("batch size", list.size()),
            kv("headers", messageHeaders)
        );

        for (TestVO testVO : list) {
            log.info("consumer data {}", testVO);
        }
    }
}

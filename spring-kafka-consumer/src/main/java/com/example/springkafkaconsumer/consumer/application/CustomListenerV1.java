package com.example.springkafkaconsumer.consumer.application;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomListenerV1 {

  @KafkaListener(
    topics = "${spring.kafka.topics.record-test}",
    groupId = "${spring.kafka.consumer.group-id}",
    containerFactory = "customContainerFactoryV1"
  )
  public void onMessage(ConsumerRecord<String, TestVO> message, Acknowledgment ack) {
    log.info("partition key: {}", message.key());
    log.info("value: {}", message.value());
    log.info("offset: {}", message.offset());
    ack.acknowledge();
  }

  @KafkaListener(
    topics = "${spring.kafka.topics.record-test2}",
    groupId = "${spring.kafka.consumer.group-id}",
    containerFactory = "customContainerFactoryV2"
  )
  public void onMessage(ConsumerRecord<String, TestVO> message) {
    log.info("message {}", message);
  }
}

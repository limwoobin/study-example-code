package com.example.springkafkaconsumer.consumer.application;

import lombok.extern.slf4j.Slf4j;
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
//  public void consume(@Payload TestVO testVO, Acknowledgment ack) {
//    log.info("jsonConsume message {} ", testVO);
//    ack.acknowledge();
//  }
  public void consume(ConsumerRecord<String, TestVO> message, Acknowledgment ack) {
    log.info("partition key: {}", message.key());
    log.info("value: {}", message.value());
    log.info("offset: {}", message.offset());
    ack.acknowledge();
  }
}

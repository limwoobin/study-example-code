package com.example.springkafka.producer.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageSender<T> {
    @Value("${spring.kafka.producer.topics.exam3}")
    private String examTopic;

    private final KafkaTemplate<String, T> jsonKafkaTemplate;

    public void send(T message) {
        Message<T> data = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, examTopic)
                .build();

        ListenableFuture<SendResult<String, T>> future = jsonKafkaTemplate.send(data);

        future.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("throw ex {} ", ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                log.info("Send Message {} {}",
                        kv("value", result.getProducerRecord().value().toString()),
                        kv("offset", result.getRecordMetadata().offset())
                );
            }
        });
    }
}

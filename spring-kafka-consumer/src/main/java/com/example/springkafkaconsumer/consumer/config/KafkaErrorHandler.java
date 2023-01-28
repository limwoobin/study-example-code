package com.example.springkafkaconsumer.consumer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaErrorHandler implements KafkaListenerErrorHandler {
    @Value("${spring.kafka.topics.dead-letter}")
    private String deadLetter;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        ConsumerRecord<String, String> record = (ConsumerRecord<String, String>) message.getPayload();

        log.error("[KafkaErrorHandler] {}, {}, {}, {}, {}",
                kv("topic", record.topic()),
                kv("offset", record.offset()),
                kv("value", record.value()),
                kv("exception", exception.getCause()),
                kv("exceptionMessage", exception.getCause().getMessage())
        );

        kafkaTemplate.send(deadLetter, record.value());
        Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
        offsets.put(
                new TopicPartition(record.topic(), record.partition()),
                new OffsetAndMetadata(record.offset() + 1, null)
        );

        consumer.commitSync(offsets);
        return record.value();
    }
}

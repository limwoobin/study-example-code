package com.example.springkafkaconsumer.consumer.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaErrorHandler implements KafkaListenerErrorHandler {
    @Value("${spring.kafka.topics.dead-letter}")
    private String deadLetter;

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {

        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }
}

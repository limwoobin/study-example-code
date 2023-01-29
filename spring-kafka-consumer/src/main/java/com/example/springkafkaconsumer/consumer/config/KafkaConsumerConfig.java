package com.example.springkafkaconsumer.consumer.config;

import com.example.springkafkaconsumer.consumer.application.TestVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.kv;

@EnableKafka
@Configuration
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value(value = "${spring.kafka.backoff.interval}")
    private Long interval;

    @Value(value = "${spring.kafka.backoff.max_failure}")
    private Long maxAttempts;

    @Value("${spring.kafka.topics.dead-letter}")
    private String deadLetter;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = consumerConfigMap();
        return new DefaultKafkaConsumerFactory<>(config);
    }

    private Map<String, Object> consumerConfigMap() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return config;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> containerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setCommonErrorHandler(errorHandler());

        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> jsonContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setMessageConverter(converter());

        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TestVO>> batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TestVO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(batchConsumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.BATCH);
        factory.setBatchListener(true);
        factory.setConcurrency(3);

        return factory;
    }

    @Bean
    public ConsumerFactory<String, TestVO> batchConsumerFactory() {
        Map<String, Object> config = consumerConfigMap();
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10");

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                new JsonDeserializer<>(TestVO.class, false)
        );
    }

    @Bean
    public RecordMessageConverter converter(){
        return new StringJsonMessageConverter(objectMapper);
    }

    @Bean
    public DefaultErrorHandler errorHandler() {
        BackOff fixedBackOff = new FixedBackOff(interval, maxAttempts);
        DefaultErrorHandler errorHandler = new DefaultErrorHandler((consumerRecord, exception) -> {
            ConsumerRecord<String, String> record = (ConsumerRecord<String, String>) consumerRecord;
            log.error("[KafkaErrorHandler] {}, {}, {}, {}, {}",
                    kv("topic", record.topic()),
                    kv("offset", record.offset()),
                    kv("value", record.value()),
                    kv("exception", exception.getCause()),
                    kv("exceptionMessage", exception.getCause().getMessage())
            );

            kafkaTemplate.send(deadLetter, record.value());
            log.info("dead letter send success {}", consumerRecord.value());
        }, fixedBackOff);

//        errorHandler.addRetryableExceptions(SocketTimeoutException.class);    // 재시도 할 수 있는 예외
//        errorHandler.addNotRetryableExceptions(NullPointerException.class);   // 재시도 할 수 없는 예외

        return errorHandler;
    }
}

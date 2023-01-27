package com.example.springkafka.producer.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final KafkaMessageSender<TestVO> kafkaMessageSender;

    @GetMapping(value = "/{message}")
    public ResponseEntity<Void> send(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/json/{message}")
    public ResponseEntity<Void> sendJson(@PathVariable String message) {
        kafkaProducer.sendJsonMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/sender/{message}")
    public ResponseEntity<Void> send2(@PathVariable String message) {
        TestVO testVO = new TestVO(message, 20);

        kafkaMessageSender.send(testVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/batch/{message}")
    public ResponseEntity<Void> batchSend(@PathVariable String message) {
        kafkaProducer.sendBatchMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/error-topic/{message}")
    public ResponseEntity<Void> errorTopicSend(@PathVariable String message) {
        kafkaProducer.sendErrorTopicMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

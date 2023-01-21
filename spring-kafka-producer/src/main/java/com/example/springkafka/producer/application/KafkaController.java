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
}

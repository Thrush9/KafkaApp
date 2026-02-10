package com.application.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class KafkaConsumerController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaConsumerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String msg){
        kafkaTemplate.send("my-topic", msg);
        return "Message Sent ::: " + msg;
    }


}

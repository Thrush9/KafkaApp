package com.application.kafka.controller;

import com.application.kafka.model.RiderLocation;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaProducerController {

    private final KafkaTemplate<String,String> kafkaTemplate1;
    private final KafkaTemplate<String,RiderLocation> kafkaTemplate2;

    public KafkaProducerController(KafkaTemplate<String,String> kafkaTemplate1, KafkaTemplate<String, RiderLocation> kafkaTemplate2) {
        this.kafkaTemplate1 = kafkaTemplate1;
        this.kafkaTemplate2 = kafkaTemplate2;
    }

    @PostMapping("/sendStringMessage")
    public String sendStringMessage(@RequestParam String msg){
        kafkaTemplate1.send("my-topic", msg);
        return "Message Sent ::: " + msg;
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String msg){
        RiderLocation newRider = new RiderLocation("rider-123",22.78,66.98, msg);
        kafkaTemplate2.send("my-rider-topic", newRider);
        return "Message Sent ::: " + newRider.toString();
    }


}

package com.application.kafka.config;

import com.application.kafka.model.RiderLocation;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerConfig {

    @KafkaListener(topics = "my-topic",groupId = "my-group")
    public void listenForMyGroup(String message){
        System.out.println("Received Message in my-group :: " + message);
    }

    @KafkaListener(topics = "my-rider-topic",groupId = "my-rider-group")
    public void listenForRiderLocation(RiderLocation riderLocation){
        System.out.println("Received RiderLocation in my-group :: " + riderLocation);
    }


}

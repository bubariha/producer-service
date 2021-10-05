package com.microservice.producerservie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static String kafkaTopic = "test-topic";

    public void sedMessage(String message) {
        kafkaTemplate.send(kafkaTopic, "Fine");
    }

}

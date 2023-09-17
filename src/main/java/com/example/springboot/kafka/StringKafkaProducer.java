package com.example.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.warn(String.format("Message sent %s", message));
        kafkaTemplate.send("topic", message);
    }
}

package com.santeco.pss.kafka;

import com.santeco.pss.payload.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Order> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Order data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));
        Message<Order> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "pss_order")
                .build();
        kafkaTemplate.send(message);
    }
}

package com.github.osvaldsoza.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestConsumer {

    @KafkaListener(
            topics = "payment.request.topic.v1",
            groupId = "payment-request-consumer-1"
    )
    public void consume(String message){
        System.out.println("==== MESSAGE RECEIVE ==== " + message);
    }
}

package com.github.osvaldsoza.kafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.osvaldsoza.kafkaproducer.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestProducer {

    @Value("${topics.payment.request.topic}")
    private String paymentRequestTopic;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentRequestProducer(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(PaymentDTO paymentDTO) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(paymentDTO);
        kafkaTemplate.send(paymentRequestTopic, content);
        return  "Payment sent for processing";
    }
}

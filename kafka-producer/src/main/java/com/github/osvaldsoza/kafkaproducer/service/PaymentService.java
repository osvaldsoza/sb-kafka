package com.github.osvaldsoza.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.osvaldsoza.kafkaproducer.dto.PaymentDTO;
import com.github.osvaldsoza.kafkaproducer.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRequestProducer paymentRequestProducer;

    public String integratePayment(PaymentDTO paymentDTO){
        try {
            return paymentRequestProducer.sendMessage(paymentDTO);
        } catch (JsonProcessingException e) {
           return  "There was as error requesting payment." + e.getMessage();
        }
    }
}

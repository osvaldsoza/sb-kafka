package com.github.osvaldsoza.kafkaproducer.api;

import com.github.osvaldsoza.kafkaproducer.dto.PaymentDTO;
import com.github.osvaldsoza.kafkaproducer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentApi {

    private final PaymentService paymentService;

    public PaymentApi(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String pay(@RequestBody PaymentDTO paymentDTO){
        return paymentService.integratePayment(paymentDTO);
    }
}

package com.github.osvaldsoza.kafkaproducer.dto;

import java.math.BigDecimal;

public record PaymentDTO(
        Integer number,
        String description,
        BigDecimal value) {
}

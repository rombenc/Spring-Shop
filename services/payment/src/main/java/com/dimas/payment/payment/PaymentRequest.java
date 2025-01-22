package com.dimas.payment.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        String id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String orderId,
        String orderReference,
        Customer customer
) {
}

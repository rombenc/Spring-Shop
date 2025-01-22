package com.dimas.order.payment;

import com.dimas.order.customer.CustomerResponse;
import com.dimas.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String orderId,
        String orderReference,
        CustomerResponse customer
) {
}
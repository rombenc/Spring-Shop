package com.dimas.order.kafka;

import com.dimas.order.customer.CustomerResponse;
import com.dimas.order.order.PaymentMethod;
import com.dimas.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}

package com.dimas.order.order;

import com.dimas.order.product.PurchaseRequest;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        String id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId,
        List<PurchaseRequest> products
) {
}

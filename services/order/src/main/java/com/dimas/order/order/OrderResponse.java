package com.dimas.order.order;

import java.math.BigDecimal;

public record OrderResponse(
        String id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String costumerId
) {
}

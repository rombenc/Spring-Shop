package com.dimas.order.orderline;

public record OrderLineRequest(
        String id,
        String orderId,
        String productId,
        double quantity) {
}

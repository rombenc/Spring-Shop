package com.dimas.order.product;

public record PurchaseRequest(
        String productId,
        double quantity
) {
}

package com.dimas.product.product;

public record ProductPurchaseRequest(
        String productId,
        double quantity
) {
}

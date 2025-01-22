package com.dimas.product.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        String productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}

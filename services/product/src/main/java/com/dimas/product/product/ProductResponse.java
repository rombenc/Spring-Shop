package com.dimas.product.product;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        String categoryId,
        String categoryName,
        String categoryDescription
) {
}

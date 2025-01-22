package com.dimas.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        String id,
        @NotNull(message = "product name cannot be empty")
        String name,
        @NotNull(message = "description is required")
        String description,
        double availableQuantity,
        @Positive(message = "price must be positive")
        BigDecimal price,

        String categoryId
) {
}

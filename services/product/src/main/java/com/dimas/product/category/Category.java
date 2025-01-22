package com.dimas.product.category;

import com.dimas.product.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {
    @Id
    private String id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

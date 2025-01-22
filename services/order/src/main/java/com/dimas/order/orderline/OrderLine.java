package com.dimas.order.orderline;

import com.dimas.order.order.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderLine {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String productId;

    private double quantity;

    

}

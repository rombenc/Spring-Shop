package com.dimas.order.orderline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, String> {
    List<OrderLine> findAllByOrderId(String orderId);
}

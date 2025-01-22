package com.dimas.order.order;

import com.dimas.order.customer.CustomerClient;
import com.dimas.order.exception.BusinessException;
import com.dimas.order.kafka.OrderConfirmation;
import com.dimas.order.kafka.OrderProducer;
import com.dimas.order.orderline.OrderLineRequest;
import com.dimas.order.orderline.OrderLineService;
import com.dimas.order.payment.PaymentClient;
import com.dimas.order.payment.PaymentRequest;
import com.dimas.order.product.ProductClient;
import com.dimas.order.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public String createOrder(OrderRequest request) {
        // check if we have any customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("cannot create order because the customer is not found"));
        // purchase the product using rest template
        var purchaseProducts = this.productClient.purchaseProducts(request.products());
        // persist order
        var order = this.repository.save(mapper.toOrder(request));
        // persist the order line
        for (PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(new OrderLineRequest(
                    null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()));
        }
        // start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer);
        paymentClient.requestOrderPayment(paymentRequest);
        orderProducer.sendOrderConfirmation(new OrderConfirmation(
                request.reference(),
                request.amount(),
                request.paymentMethod(),
                customer,
                purchaseProducts
        ));

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(String orderId) {
        return repository.findById(orderId)
                .stream()
                .map(mapper::fromOrder)
                .findAny().orElseThrow(()->new EntityNotFoundException("No order found with provided id"));
    }
}

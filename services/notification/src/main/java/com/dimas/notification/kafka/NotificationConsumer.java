package com.dimas.notification.kafka;

import com.dimas.notification.email.EmailService;
import com.dimas.notification.kafka.order.OrderConfirmation;
import com.dimas.notification.kafka.payment.PaymentConfirmation;
import com.dimas.notification.notification.Notification;
import com.dimas.notification.notification.NotificationRepository;
import com.dimas.notification.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.dimas.notification.notification.NotificationType.ORDER_CONFIRMATION;
import static com.dimas.notification.notification.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation confirmation) throws MessagingException {
        log.info(String.format("consuming the message from payment-topic Topic:: %s", confirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(confirmation)
                        .build()
        );
        //todo:send email here
        var customerName = confirmation.customerFirstName() + " " + confirmation.customerLastName();
        emailService.sendPaymentSuccessEmail(
                confirmation.customerEmail(),
                customerName,
                confirmation.amount(),
                confirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(String.format("consuming the message from order-topic Topic:: %s", orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        //todo:send email here
        var customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );
    }
}

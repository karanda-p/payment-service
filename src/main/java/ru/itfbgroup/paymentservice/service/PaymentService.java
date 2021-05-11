package ru.itfbgroup.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itfbgroup.paymentservice.model.Order;
import ru.itfbgroup.paymentservice.model.PaymentDetails;
import ru.itfbgroup.paymentservice.model.PaymentStatus;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class PaymentService {

    private final RabbitTemplate template;
    private final Exchange exchange;
    @Value("${message.food-delivery-routing-key}")
    private String routingKey;

    public PaymentDetails commitPayment(Order order){

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(order.getAmount());
        paymentDetails.setPaymentStatus(PaymentStatus.DONE);
        paymentDetails.setDoneDate(LocalDateTime.now());
        paymentDetails.setDetails(order.getId());
        return paymentDetails;
        
    }

    public void commitPaymentRabbit(Order order){
        template.convertAndSend(exchange.getName(), routingKey, commitPayment(order));
    }
}

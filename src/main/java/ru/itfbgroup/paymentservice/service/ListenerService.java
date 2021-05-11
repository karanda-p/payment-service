package ru.itfbgroup.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.itfbgroup.paymentservice.model.Order;

@Service
@RequiredArgsConstructor
public class ListenerService {

    private final PaymentService paymentService;

    @RabbitListener(queues = "${message.payment-queue}")
    public void receive(Order order){
        paymentService.commitPaymentRabbit(order);
    }
}

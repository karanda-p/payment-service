package ru.itfbgroup.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itfbgroup.paymentservice.entity.Order;
import ru.itfbgroup.paymentservice.entity.PaymentDetails;
import ru.itfbgroup.paymentservice.service.PaymentService;


@RestController(value = "/")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public PaymentDetails commitPayment(@RequestBody Order order) {
        return paymentService.commitPayment(order);
    }
}

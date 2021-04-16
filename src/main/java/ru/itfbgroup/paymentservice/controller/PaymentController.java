package ru.itfbgroup.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itfbgroup.paymentservice.model.Order;
import ru.itfbgroup.paymentservice.model.PaymentDetails;
import ru.itfbgroup.paymentservice.service.PaymentService;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public PaymentDetails commitPayment(@RequestBody Order order) {
        return paymentService.commitPayment(order);
    }
}

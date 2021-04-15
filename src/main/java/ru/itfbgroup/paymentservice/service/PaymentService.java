package ru.itfbgroup.paymentservice.service;

import org.springframework.stereotype.Service;
import ru.itfbgroup.paymentservice.entity.Order;
import ru.itfbgroup.paymentservice.entity.PaymentDetails;
import ru.itfbgroup.paymentservice.entity.PaymentStatus;


@Service
public class PaymentService {

    public PaymentDetails commitPayment(Order order){

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(order.getAmount());
        paymentDetails.setPaymentStatus(PaymentStatus.DONE);
        System.out.println("!!!!!!!!!!!!!!!!");
        return paymentDetails;
    }
}

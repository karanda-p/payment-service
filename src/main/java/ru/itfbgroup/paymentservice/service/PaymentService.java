package ru.itfbgroup.paymentservice.service;

import org.springframework.stereotype.Service;
import ru.itfbgroup.paymentservice.model.Order;
import ru.itfbgroup.paymentservice.model.PaymentDetails;
import ru.itfbgroup.paymentservice.model.PaymentStatus;


@Service
public class PaymentService {

    public PaymentDetails commitPayment(Order order){

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setAmount(order.getAmount());
        paymentDetails.setPaymentStatus(PaymentStatus.DONE);
        return paymentDetails;
    }
}

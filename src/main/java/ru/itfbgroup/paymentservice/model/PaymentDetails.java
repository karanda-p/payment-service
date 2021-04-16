package ru.itfbgroup.paymentservice.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDetails {

    private Long id;
    private LocalDateTime doneDate;
    private double amount;
    private PaymentStatus paymentStatus;

}

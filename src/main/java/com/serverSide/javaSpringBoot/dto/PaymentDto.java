package com.serverSide.javaSpringBoot.dto;

import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private long paymentId;
    private int amount;
    private Date datePayment;
    private String details;

}

package com.serverSide.javaSpringBoot.model.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="stripe")
public class StripePaymentModel extends PaymentModel {

    @Column(name = "account_email", nullable = false)
    private String account_email;

    @Column(name = "expiration_date", nullable = false)
    private Date expiration_date;

}

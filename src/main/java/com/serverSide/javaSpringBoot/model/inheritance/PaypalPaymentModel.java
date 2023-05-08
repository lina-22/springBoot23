package com.serverSide.javaSpringBoot.model.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="paypal")
public class PaypalPaymentModel extends PaymentModel {

    @Column(name = "account_email", nullable = false)
    private String account_email;
}

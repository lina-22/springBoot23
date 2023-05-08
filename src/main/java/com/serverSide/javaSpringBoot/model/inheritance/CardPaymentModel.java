package com.serverSide.javaSpringBoot.model.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="card")
public class CardPaymentModel extends PaymentModel {

    @Column(name = "card_number", nullable = false)
    private String card_number;


}

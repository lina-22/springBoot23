package com.serverSide.javaSpringBoot.model.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name="card")
public class CardPaymentModel extends PaymentModel {

    @Column(name = "card_number", nullable = false)
    private String card_number;

    public CardPaymentModel(long l, BigDecimal i, Date date, String test_details, ReservationModel reservationModel, UserModel userModel, String s){
        super(l, i, date, test_details, reservationModel);
        this.card_number = s;
    }

}

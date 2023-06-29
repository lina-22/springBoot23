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
@Table(name="stripe")
public class StripePaymentModel extends PaymentModel {

    @Column(name = "account_email", nullable = false)
    private String account_email;

    public StripePaymentModel(long l, BigDecimal i, Date date, String test_details, ReservationModel reservationModel, UserModel userModel, String s) {
        super(l, i, date, test_details, reservationModel);
        this.account_email = s;
    }

}

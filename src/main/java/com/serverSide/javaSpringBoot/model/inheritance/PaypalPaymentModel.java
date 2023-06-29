package com.serverSide.javaSpringBoot.model.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name="paypal")
public class PaypalPaymentModel extends PaymentModel {

    @Column(name = "account_email", nullable = false)
    private String account_email;

    public PaypalPaymentModel(long l,
                              BigDecimal i,
                              Date date,
                              String test_details,
                              ReservationModel reservationModel,
                              String s) {
        super(l, i, date, test_details, reservationModel);
        this.account_email = s;
    }
}

package com.serverSide.javaSpringBoot.dto.inheritance;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalPaymentDto extends PaymentModel {
    private String accountEmail;
    private BigDecimal amount;
    private Date paymentDate;
    private String details;
    private List<Long> reservationIds;
    private long userId;
}


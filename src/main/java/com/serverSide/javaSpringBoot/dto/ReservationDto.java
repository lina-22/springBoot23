package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private long reservationId;
    private  String reference;
    private  String status;
    private Date expireDate;
    private  long paymentId;
    private List<Long> availableProductIds;
}

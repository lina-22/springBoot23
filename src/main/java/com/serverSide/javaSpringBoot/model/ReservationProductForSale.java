package com.serverSide.javaSpringBoot.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ReservationProductForSale {

    @EmbeddedId
    private ReservationProductForSaleId id = new ReservationProductForSaleId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("reservationId")
    private ReservationModel reservationModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private ProductForSale productForSale;

    private int qty;

}

package com.serverSide.javaSpringBoot.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ReservationAvailableProduct {

    @EmbeddedId
    private ReservationAvailableProductId id = new ReservationAvailableProductId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("reservationId")
    private ReservationModel reservationModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ap_id")
    private AvailableProductModel availableProductModel;

    private int Qty;

    /*public ReservationAvailableProduct(ReservationAvailableProductId id, ReservationModel reservationModel, AvailableProductModel availableProductModel, int qty) {
        this.id = new ReservationAvailableProductId( availableProductModel.getApId(), reservationModel.getReservationId());
        this.reservationModel = reservationModel;
        this.availableProductModel = availableProductModel;
        Qty = qty;
    }

    public ReservationAvailableProduct() {
    }*/
}

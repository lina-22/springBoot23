package com.serverSide.javaSpringBoot.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import java.io.Serializable;

@Entity
public class ReservationAvailableProduct {

    @EmbeddedId
    private ReservationAvailableProductId id = new ReservationAvailableProductId();

    @ManyToOne
    @MapsId("reservationId")
    private ReservationModel reservationModel;

    @ManyToOne
    @MapsId("ap_id")
    private AvailableProductModel availableProductModel;

    private int Qty;

}

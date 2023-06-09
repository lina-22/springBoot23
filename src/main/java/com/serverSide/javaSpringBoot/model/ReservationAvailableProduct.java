package com.serverSide.javaSpringBoot.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

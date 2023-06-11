package com.serverSide.javaSpringBoot.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ReservationAvailableProductId implements Serializable {
    private long reservationId;
    private long ap_id;
}

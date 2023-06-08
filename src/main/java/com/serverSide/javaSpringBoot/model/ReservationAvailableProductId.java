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

    private static final long serialVersionUID = 1L;
    private Long reservationId;
    private Long ap_id;
}

package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.model.ReservationAvailableProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

public interface ReservationAvailableProductService {
    ReservationAvailableProduct create(ReservationAvailableProduct reservationAvailableProduct);

}

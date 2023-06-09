package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ReservationAvailableProduct;
import com.serverSide.javaSpringBoot.repository.ReservationAvailableProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationAvailableProductServiceImpl implements ReservationAvailableProductService{

    private ReservationAvailableProductRepository repository;

    @Override
    public ReservationAvailableProduct create(ReservationAvailableProduct reservationAvailableProduct) {
        return repository.save(reservationAvailableProduct);
    }
}

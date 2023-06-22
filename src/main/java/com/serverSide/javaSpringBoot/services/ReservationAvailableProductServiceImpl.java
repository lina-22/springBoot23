package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ReservationProductForSale;
import com.serverSide.javaSpringBoot.repository.ReservationProductForSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationAvailableProductServiceImpl implements ReservationAvailableProductService{

    private ReservationProductForSaleRepository repository;

    @Override
    public ReservationProductForSale create(ReservationProductForSale reservationProductForSale) {
        return repository.save(reservationProductForSale);
    }
}

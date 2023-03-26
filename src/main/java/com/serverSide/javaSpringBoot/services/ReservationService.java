package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ReservationModel;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public ReservationModel create(ReservationModel reservationModel);
    public Optional<ReservationModel> findById(Long reservation_id);

    public List<ReservationModel> findAll();

    public ReservationModel update(ReservationModel reservationModel);

    public  void delete(long reservation_id);
}

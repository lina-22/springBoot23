package com.clickAndcollect.javaSpringBoot.services;

import com.clickAndcollect.javaSpringBoot.model.ReservationModel;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public ReservationModel insert(ReservationModel reservationModel);
    public Optional<ReservationModel> findById(Long id);

    public List<ReservationModel> findAll();

    public ReservationModel update(ReservationModel reservationModel);
}

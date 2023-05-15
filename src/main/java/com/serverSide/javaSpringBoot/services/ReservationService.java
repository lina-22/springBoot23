package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ReservationModel;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

     ReservationModel create(ReservationModel reservationModel);
     Optional<ReservationModel> findById(long reservation_id);

     List<ReservationModel> findAll();

    List<ReservationModel> findAllByIds(List<Long>ids);

     ReservationModel update(ReservationModel reservationModel);

      void delete(long reservation_id);
}

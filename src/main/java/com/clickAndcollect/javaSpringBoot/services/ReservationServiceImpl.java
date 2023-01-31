package com.clickAndcollect.javaSpringBoot.services;

import com.clickAndcollect.javaSpringBoot.model.ReservationModel;
import com.clickAndcollect.javaSpringBoot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository mReservationRepository;

    @Override
    public ReservationModel insert(ReservationModel reservationModel){

        return  mReservationRepository.save(reservationModel);
    }
    @Override
    public Optional<ReservationModel> findById(Long id) {

        return mReservationRepository.findById(id);
    }

    @Override
    public List<ReservationModel> findAll() {

        return mReservationRepository.findAll();
    }

    @Override
    public ReservationModel update(ReservationModel reservationModel){
        return  mReservationRepository.save(reservationModel);
    }
}

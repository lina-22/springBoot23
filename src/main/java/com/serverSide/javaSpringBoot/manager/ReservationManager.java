package com.serverSide.javaSpringBoot.manager;


import com.serverSide.javaSpringBoot.dto.AvailableProductDto;
import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;
import com.serverSide.javaSpringBoot.services.ReservationService;

public class ReservationManager {

    private ReservationService reservationService;
    public ReservationDto createReservation(ReservationDto reservationDto){
       ReservationModel reservationToAdd = toReservationModel(reservationDto);
       ReservationModel addedReservation = reservationService.create(reservationToAdd);

       return toReservationDto(addedReservation);
    }

    // ******************* the dto to model data transfer****************
    public ReservationModel toReservationModel(ReservationDto reservationDto){
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReference(reservationDto.getReference());
        reservationModel.setStatus(reservationDto.getStatus());
        reservationModel.setExpireDate(reservationDto.getExpireDate());

        return reservationModel;
    }

    public ReservationDto toReservationDto(ReservationModel reservationModel){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationModel.getId());
        reservationDto.setReference(reservationModel.getReference());
        reservationDto.setStatus(reservationModel.getStatus());
        reservationDto.setExpireDate(reservationModel.getExpireDate());

        return  reservationDto;
    }


    // *******************the dto to model data transfer****************
}

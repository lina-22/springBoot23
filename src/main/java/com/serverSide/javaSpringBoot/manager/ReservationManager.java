package com.serverSide.javaSpringBoot.manager;


import com.serverSide.javaSpringBoot.dto.AvailableProductDto;
import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;

public class ReservationManager {
    // ******************* the dto to model data transfer****************
    public ReservationModel toReservationModel(ReservationDto reservationDto){
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReference(reservationDto.getReference());
        reservationModel.setStatus(reservationDto.getStatus());
        reservationModel.setExpireDate(reservationDto.getExpireDate());

        return reservationModel;
    }

    public ReservationDto toAvailableProductDto(ReservationModel reservationModel){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationModel.getId());
        reservationDto.setReference(reservationModel.getReference());
        reservationDto.setStatus(reservationModel.getStatus());
        reservationDto.setExpireDate(reservationModel.getExpireDate());

        return  reservationDto;
    }


    // *******************the dto to model data transfer****************
}

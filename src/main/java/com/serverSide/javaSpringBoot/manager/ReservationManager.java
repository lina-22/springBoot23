package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.services.AvailableProductService;
import com.serverSide.javaSpringBoot.services.ReservationService;
import com.serverSide.javaSpringBoot.services.inheritance.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ReservationManager {

    private ReservationService reservationService;

//    private PaymentService paymentService;

    private AvailableProductService availableProductService;
    public ReservationDto createReservation(ReservationDto reservationDto){
    List<AvailableProductModel> availableProducts = availableProductService.findAllByIds(reservationDto.getAvailableProductIds());
    Set<AvailableProductModel>availableProductModels = new HashSet<>(availableProducts);

    for (AvailableProductModel availableProductModel : availableProductModels) {
        System.out.println(availableProductModel.toString());
    }
    ReservationModel reservationToAdd = toReservationModel(reservationDto);
   // reservationToAdd.setMAvailableProduct(availableProductModels);

    ReservationModel addedReservation = reservationService.create(reservationToAdd);
    System.out.println("tested ok ...." + addedReservation.toString());
    return toReservationDto(addedReservation);
}

    public List<ReservationDto> getAllReservation() {
        List<ReservationDto>reservationDtoList = new ArrayList<>();
        List<ReservationModel> reservationModelList = reservationService.findAll();
        reservationModelList.forEach(data-> {
            reservationDtoList.add(toReservationDto(data));
        });
        return reservationDtoList;
    }

    public ReservationDto getReservationById(long reservationId){

        return toReservationDto(reservationService.findById(reservationId).get());
    }

    public ReservationDto updateReservation(ReservationDto reservationDto){
        Optional<ReservationModel> reservationModel =  reservationService.findById(reservationDto.getReservationId());
        if (reservationModel.isPresent()){
            reservationModel.get().setReference(reservationDto.getReference());
            reservationModel.get().setStatus(reservationDto.getReference());
            reservationModel.get().setExpireDate(reservationDto.getExpireDate());
            ReservationModel updatedReservationModel =  reservationService.update(reservationModel.get());
            return toReservationDto(updatedReservationModel);
        }
        return new ReservationDto();

    }

    public void deleteReservationById(long reservation_id){

        reservationService.delete(reservation_id);
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
        reservationDto.setReservationId(reservationModel.getReservationId());
        reservationDto.setReference(reservationModel.getReference());
        reservationDto.setStatus(reservationModel.getStatus());
        reservationDto.setExpireDate(reservationModel.getExpireDate());
//        reservationDto.setPaymentId(reservationModel.getPaymentModel().getPaymentId());

        return  reservationDto;
    }


    // *******************the dto to model data transfer****************
}

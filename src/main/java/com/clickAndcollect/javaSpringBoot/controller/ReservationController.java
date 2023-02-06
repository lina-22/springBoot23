package com.clickAndcollect.javaSpringBoot.controller;


import com.clickAndcollect.javaSpringBoot.dto.ReservationDto;

import com.clickAndcollect.javaSpringBoot.manager.ReservationManager;
import com.clickAndcollect.javaSpringBoot.model.ProductModel;
import com.clickAndcollect.javaSpringBoot.model.ReservationModel;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;
import com.clickAndcollect.javaSpringBoot.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService mReservationService;
//   id/idUser/ reference/ status/ expireDate
    @PostMapping("create")
    ResponseEntity<?> create(@RequestBody ReservationDto dto){
        MessageResponse validation = ReservationManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ReservationModel reservationModel = new ReservationModel();
            reservationModel.setReference(dto.getReference());
            reservationModel.setStatus(dto.getStatus());
            reservationModel.setExpireDate(dto.getExpireDate());
            ReservationModel isSaved =  mReservationService.insert(reservationModel);
            return ResponseEntity.ok(isSaved);

        }
    }
    @GetMapping("showOne")
    ResponseEntity<?> read(@RequestBody ReservationDto dto){
        MessageResponse validation = ReservationManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ReservationModel reservationModel = new ReservationModel();
            reservationModel.setReference(dto.getReference());
            reservationModel.setStatus(dto.getStatus());
            reservationModel.setExpireDate(dto.getExpireDate());
            ReservationModel isSaved =  mReservationService.insert(reservationModel);
            return ResponseEntity.ok(isSaved);

        }
    }

    @GetMapping("showAll")
    ResponseEntity<?> showAll(){
        return ResponseEntity.ok(mReservationService.findAll());
    }


}

package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.manager.ReservationManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationManager reservationManager;
 /*   @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto){
        return reservationManager.createReservation(reservationDto);
    }

    @GetMapping
    public List<ReservationDto> getAllReservation(){
        return reservationManager.getAllReservation();
    }*/
}
package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.dto.ReservationReqDto;
import com.serverSide.javaSpringBoot.dto.ReservationResDto;
import com.serverSide.javaSpringBoot.manager.ReservationManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationManager reservationManager;
   /* @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto){
        return reservationManager.createReservation(reservationDto);
    }*/

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity createReservation(@RequestBody ReservationReqDto reservationReqDto){
        return new ResponseEntity<>( reservationManager.createReservation(reservationReqDto), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{email}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<ReservationResDto> getAllReservationByUser(@PathVariable String email){
        return reservationManager.getAllReservationByUser(email);
    }

    @GetMapping
    public List<ReservationDto> getAllReservation(){
        return reservationManager.getAllReservation();
    }

    @GetMapping(path = "/{reservation_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ReservationDto getReservationById(@PathVariable long reservation_id){

        return reservationManager.getReservationById(reservation_id);
    }

    @PutMapping
    public ReservationDto updateReservationById(@RequestBody ReservationDto reservationDto){

        return reservationManager.updateReservation(reservationDto);
    }

    @DeleteMapping(path = "/{reservation_id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<String> deleteReservationById(@PathVariable long reservation_id){
        try{
            reservationManager.deleteReservationById(reservation_id);
            return new ResponseEntity<>("Reservation with id + " + reservation_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Reservation with " + reservation_id + " not found", HttpStatus.NOT_FOUND);
        }

    }

}
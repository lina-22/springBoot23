package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.RatingDto;
import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.manager.RatingManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

    private final RatingManager ratingManager;

    @PostMapping
    public String createRating(@RequestBody RatingDto ratingDto){

        return ratingManager.createRating(ratingDto);
    }

    @GetMapping
    public List<RatingDto> getAllRating(){

        return ratingManager.getAllRating();
    }

    @GetMapping(path="/{rating_id}")
    public RatingDto getRatingById(@PathVariable long rating_id){

        return ratingManager.getRatingById(rating_id);
    }

    @PutMapping
    public RatingDto updateRatingById(@RequestBody RatingDto ratingDto){

        return  ratingManager.updateRating(ratingDto);
    }

    @DeleteMapping(path = "/{rating_id}")
    public ResponseEntity<String> deleteRatingById(@PathVariable long rating_id){
        try{
            ratingManager.deleteRatingById(rating_id);
            return new ResponseEntity<>("Rating with id + " + rating_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            return new ResponseEntity<>("Rating with " + rating_id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}

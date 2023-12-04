package com.serverSide.javaSpringBoot.controller;


import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ColourManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colours")
@AllArgsConstructor
public class ColourController {
    private final ColourManager colourManager;

   @PostMapping
   @PreAuthorize("hasRole('ADMIN')")
    public ColourDto createColour(@RequestBody ColourDto colourDto){

        return colourManager.createColour(colourDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<ColourDto> getAllColour(){

       return colourManager.getAllColour();
    }

    @GetMapping(path= "/{colour_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ColourDto getColourById(@PathVariable long colour_id){
        return colourManager.getColourById(colour_id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ColourDto updateColourById(@RequestBody ColourDto colourDto){
        return colourManager.updateColour(colourDto);
    }

    @DeleteMapping(path = "/{colour_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteColourById(@PathVariable long colour_id){
        try{
            colourManager.deleteColourById(colour_id);
            return new ResponseEntity<>("Colour with id + " + colour_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Colour with " + colour_id + " not found", HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/test")
    public String getAllTest(){
        return "testing................";
    }

}

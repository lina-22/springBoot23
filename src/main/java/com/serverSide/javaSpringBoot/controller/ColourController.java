package com.serverSide.javaSpringBoot.controller;


import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.manager.ColourManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colours")
@AllArgsConstructor
public class ColourController {
    private final ColourManager colourManager;

   @PostMapping
    public ColourDto createColour(@RequestBody ColourDto colourDto){

        return colourManager.createColour(colourDto);
    }

    @GetMapping
    public List<ColourDto> getAllColour(){

       return colourManager.getAllColour();
    }

    @GetMapping("/test")
    public String getAllTest(){
        return "testing................";
    }

}

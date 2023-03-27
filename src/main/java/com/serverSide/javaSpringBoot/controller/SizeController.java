package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.manager.SizeManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
@AllArgsConstructor
public class SizeController {

    private final SizeManager sizeManager;

    @PostMapping
    public SizeDto createSize(@RequestBody SizeDto sizeDto){

        return sizeManager.createSize(sizeDto);
    }

    @GetMapping
    public List<SizeDto>getAllSize(){
        return sizeManager.getAllSize();
    }

    @GetMapping("/test")
    public String getAllTest(){
        return "testing................";
    }
}

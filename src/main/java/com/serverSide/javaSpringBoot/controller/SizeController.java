package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.manager.SizeManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
@AllArgsConstructor
public class SizeController {

    private final SizeManager sizeManager;

    @PostMapping
    public SizeDto createSize(@RequestBody SizeDto sizeDto){
        return sizeManager.createSize(sizeDto);
    }
}

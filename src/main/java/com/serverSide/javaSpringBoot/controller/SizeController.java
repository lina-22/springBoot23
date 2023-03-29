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


    @GetMapping(path = "/{size_id}")
    public SizeDto getSizeById(@PathVariable long size_id){
        return sizeManager.getSizeById(size_id);
    }

    @PutMapping
    public SizeDto updateSizeById(@RequestBody SizeDto sizeDto){

        return sizeManager.updateSize(sizeDto);
    }


//    @DeleteMapping(path ="/{size_id}")
//    public SizeDto deleteSize(@PathVariable long size_id){
//        SizeDto dSize = sizeManager.getSizeById(size_id);
//        sizeManager.deleteSize( size_id);
//        return  dSize;
//
//    }


    @GetMapping("/test")
    public String getAllTest(){
        return "testing................";
    }
}

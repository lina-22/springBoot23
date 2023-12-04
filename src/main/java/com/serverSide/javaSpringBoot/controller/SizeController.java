package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.manager.SizeManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
@AllArgsConstructor
public class SizeController {
    private final SizeManager sizeManager;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SizeDto createSize(@RequestBody SizeDto sizeDto){

        return sizeManager.createSize(sizeDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<SizeDto>getAllSize(){

        return sizeManager.getAllSize();
    }

    @GetMapping(path = "/{size_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public SizeDto getSizeById(@PathVariable long size_id){
        return sizeManager.getSizeById(size_id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SizeDto updateSizeById(@RequestBody SizeDto sizeDto){

        return sizeManager.updateSize(sizeDto);
    }


    @DeleteMapping(path ="/{size_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteSizeById(@PathVariable long size_id){
        try{
            sizeManager.deleteSizeById(size_id);
            return new ResponseEntity<>("Size with id+ " + size_id + "has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Size with " + size_id + " not found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/test")
    public String getAllTest(){
        return "testing................";
    }
}

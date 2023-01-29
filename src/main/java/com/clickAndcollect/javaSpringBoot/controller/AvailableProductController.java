package com.clickAndcollect.javaSpringBoot.controller;


import com.clickAndcollect.javaSpringBoot.dto.AvailableProductDto;
import com.clickAndcollect.javaSpringBoot.manager.AvailableProductManager;
import com.clickAndcollect.javaSpringBoot.model.AvailableProductModel;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;

import com.clickAndcollect.javaSpringBoot.services.AvailableProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
//    String id;
//    String colour;
//    String quantity;
//    String size;


@RestController
@RequestMapping("/availableproduct")
public class AvailableProductController {

    @Autowired
    AvailableProductService mAvailableProductService;

    @PostMapping("create")
    ResponseEntity<?> create(@RequestBody AvailableProductDto dto){
        MessageResponse validation = AvailableProductManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            AvailableProductModel availableProductModel = new AvailableProductModel();
            AvailableProductModel.setColour(dto.getColour());
            AvailableProductModel.setQuantity(dto.getQuantity());
            AvailableProductModel.setSize(dto.setSize());

            AvailableProductModel isSaved =  mAvailableProductService.insert(availableProductModel);
            return ResponseEntity.ok(isSaved);

        }
    }

    @GetMapping("showOne")
    ResponseEntity<?> read(@RequestBody  AvailableProductDto dto){
        MessageResponse validation = AvailableProductManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            AvailableProductModel availableProductModel = new AvailableProductModel();
            AvailableProductModel.setColour(dto.getColour());
            AvailableProductModel.setQuantity(dto.getQuantity());
            AvailableProductModel.setSize(dto.setSize());

            AvailableProductModel isSaved =  mAvailableProductService.insert(availableProductModel);
            return ResponseEntity.ok(isSaved);


        }
    }

    @GetMapping("showAll")
    ResponseEntity<?> showAll(){
        return ResponseEntity.ok(mAvailableProductService.findAll());
    }


    @PutMapping("update")
    ResponseEntity<?> update(@RequestBody  AvailableProductDto dto){
        MessageResponse  validation = AvailableProductManager.updatedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            MessageResponse validation = AvailableProductManager.validation(dto);
            if(!validation.isSuccess()){
                return ResponseEntity.badRequest().body(validation);
            }else {
                AvailableProductModel availableProductModel = new AvailableProductModel();
                AvailableProductModel.setColour(dto.getColour());
                AvailableProductModel.setQuantity(dto.getQuantity());
                AvailableProductModel.setSize(dto.setSize());

                AvailableProductModel isSaved =  mAvailableProductService.insert(availableProductModel);
                return ResponseEntity.ok(isSaved);

            }

        }
    }

    @PostMapping("delete")
    ResponseEntity<?> delete(@RequestBody  AvailableProductDto dto){
        MessageResponse  validation = AvailableProductManager.deletedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            MessageResponse validation = AvailableProductManager.validation(dto);
            if(!validation.isSuccess()){
                return ResponseEntity.badRequest().body(validation);
            }else {
                AvailableProductModel availableProductModel = new AvailableProductModel();
                AvailableProductModel.setColour(dto.getColour());
                AvailableProductModel.setQuantity(dto.getQuantity());
                AvailableProductModel.setSize(dto.setSize());

                AvailableProductModel isSaved =  mAvailableProductService.insert(availableProductModel);
                return ResponseEntity.ok(isSaved);

            }

        }
    }

}

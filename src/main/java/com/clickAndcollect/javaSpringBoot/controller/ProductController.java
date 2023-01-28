package com.clickAndcollect.javaSpringBoot.controller;

import com.clickAndcollect.javaSpringBoot.dto.ProductDto;
import com.clickAndcollect.javaSpringBoot.manager.ProductManager;
import com.clickAndcollect.javaSpringBoot.model.ProductModel;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;

import com.clickAndcollect.javaSpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    ProductService mProductService;

    @PostMapping("create")
    ResponseEntity<?> create(@RequestBody ProductDto dto){
        MessageResponse validation = ProductManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ProductModel productModel = new ProductModel();
            productModel.setName(dto.getName());
            ProductModel isSaved =  mProductService.insert(productModel);
            return ResponseEntity.ok(isSaved);

        }
    }

    @GetMapping("showOne")
    ResponseEntity<?> read(@RequestBody  ProductDto dto){
        MessageResponse  validation = ProductManager.readValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ProductModel productModel = new ProductModel();
            productModel.setId(dto.getId());
            productModel.setName(dto.getName());
            productModel.setIs_featured(dto.isIs_featured());
            productModel.setPrice(dto.getPrice());
            productModel.setName(dto.getName());
            productModel.setName(dto.getName());
            ProductModel isSaved =  mProductService.update(productModel);
            return ResponseEntity.ok(isSaved);
        }
    }

    @GetMapping("showAll")
    ResponseEntity<?> showAll(){
        return ResponseEntity.ok(mProductService.findAll());
    }


    @PutMapping("update")
    ResponseEntity<?> update(@RequestBody  ProductDto dto){
        MessageResponse  validation = ProductManager.updatedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ProductModel productModel = new ProductModel();
            productModel.setId(dto.getId());
            productModel.setName(dto.getName());
            ProductModel isSaved =  mProductService.update(productModel);
            return ResponseEntity.ok(isSaved);
        }
    }

    @PostMapping("delete")
    ResponseEntity<?> delete(@RequestBody  ProductDto dto){
        MessageResponse  validation = ProductManager.deletedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            ProductModel productModel = new ProductModel();
            productModel.setName(dto.getId());
            productModel.setName(dto.getName());
            ProductModel isSaved =  mProductService.update(productModel);
            return ResponseEntity.ok(isSaved);
        }
    }

}

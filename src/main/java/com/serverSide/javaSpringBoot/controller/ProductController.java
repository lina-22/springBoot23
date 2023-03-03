package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ProductManager;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;

import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
class ProductController {

    private final ProductManager productManager;

    @GetMapping
    public List<ProductDto>getAllProduct(){
        return productManager.getAllProduct();
    }
}
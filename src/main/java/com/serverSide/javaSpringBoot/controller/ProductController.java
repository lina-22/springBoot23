package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ProductManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // restapi create
@RequestMapping("/products")
@AllArgsConstructor // it brings all kinds of constructor as polymorphism
class ProductController {

    private final ProductManager productManager;  // i bring the productManager data type or constructor here for use this class to do the CRUD operation
    // and with the final keyword i mention that this information i can use it but cannot change the info anymore

    // requestbody comes from responseEntity(requestbody+requestparam) responseEntity bring some  meta information
    // i will pass/create the data from client side by using productDto, so at the parameter i need to pass the pruductdto where i stored the data
    // here line no 25 createProduct is a variable and line no 26 createProduct is a method from productManager and inside i pass the productDto object??
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productManager.createProduct(productDto);
    }


    @GetMapping
    public List<ProductDto>getAllProduct(){

        return productManager.getAllProduct();
    }

    //@GetMapping
    //public ProductDto getOneProduct(long id){
      //  return productManager.getOneProduct();
    //}


}
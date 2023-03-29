package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ProductManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
class ProductController {

    private final ProductManager productManager;
   @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productManager.createProduct(productDto);
    }


    @GetMapping
    public List<ProductDto>getAllProduct(){

       return productManager.getAllProduct();
    }

    @GetMapping(path= "/{product_id}")
    public ProductDto getProductById(@PathVariable long product_id){
        return productManager.getProductById(product_id);
    }

    @PutMapping
    public ProductDto updateProductById(@RequestBody ProductDto productDto){
        return productManager.updateProduct(productDto);
    }

    @DeleteMapping(path = "/{product_id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long product_id){
        try{
            productManager.deleteProductById(product_id);
            return new ResponseEntity<>("Product with id + " + product_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Product with " + product_id + " not found", HttpStatus.NOT_FOUND);
        }

    }


}
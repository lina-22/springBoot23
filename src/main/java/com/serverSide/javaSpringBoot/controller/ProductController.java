package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.manager.ProductManager;
import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
class ProductController {

    private final ProductManager productManager;

    @PostMapping
    public ProductDto createProduct(@RequestPart ProductDto productDto, @RequestPart MultipartFile image){
        return productManager.createAndUpdateProduct(productDto, image);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ProductDto>getAllProduct(){

        return productManager.getAllProduct();
    }

    @GetMapping(path= "/{pageNumber}/{size}")
    public Page getProductPaginated(@PathVariable int pageNumber, @PathVariable int size){
       return productManager.getAllProductPaginated(pageNumber, size);
    }

    @GetMapping(path= "/{product_id}")
    public ProductDto getProductById(@PathVariable long product_id){
        return productManager.getProductById(product_id);
    }

    @PutMapping
    public ProductDto updateProductById(@RequestPart ProductDto productDto, @RequestPart MultipartFile image){
        return productManager.createAndUpdateProduct(productDto,image);
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
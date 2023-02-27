package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.response.MessageResponse;


// after creation of dt the prductmanager has been created for handle the message response
public class ProductManager {

    public static MessageResponse validation(ProductDto dto){
        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }
        //        *********************is featured need to verify*******************************

        if(dto.getPrice() < 0.0){
            return new MessageResponse(false, "Product price not provided");
        }
        if(dto.getDiscount() < 0.0){
            return new MessageResponse(false, "Product discount price not provided");
        }
        if(dto.getImage().isEmpty()){
            return new MessageResponse(false, "Product image not provided");
        }

        if(dto.getDescription().isEmpty()){
            return new MessageResponse(false, "Product Description name not provided");
        }else {
            return new MessageResponse( "Product Successfully validated");
        }

    }

    public static MessageResponse readValidation(String id){
        if(id.isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }else {
            return new MessageResponse("Successfully validated");
        }
    }
    public static MessageResponse updatedValidation(ProductDto dto){
        if(dto.getId() <= 0){
            return new MessageResponse(false, "Product id not provided");
        }else {
            return new MessageResponse( "Product Successfully validated");
        }
    }
    public static MessageResponse deleteValidation(Long id){
        if(id.toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        } else {
            return new MessageResponse( "Product Successfully validated");
        }


    }
}

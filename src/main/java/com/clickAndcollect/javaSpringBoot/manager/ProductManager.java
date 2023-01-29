package com.clickAndcollect.javaSpringBoot.manager;

import com.clickAndcollect.javaSpringBoot.dto.ProductDto;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;

public class ProductManager {

    public static MessageResponse validation(ProductDto dto){

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }
//                *********************is featured need to verify*******************************
//        if(dto.isIs_featured()){
//            return new MessageResponse(false, "Product name not provided");
//        }
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

    public static MessageResponse readValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }
        //        *********************is featured need to verify*******************************
        if(dto.isIs_featured()){
            return new MessageResponse(false, "Product name not provided");
        }
        if(dto.getPrice()<0.0){
            return new MessageResponse(false, "Product price not provided");
        }
        if(dto.getDiscount()<0.0){
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

    public static MessageResponse updatedValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }
        //        *********************is featured need to verify*******************************
        if(dto.isIs_featured()){
            return new MessageResponse(false, "Product name not provided");
        }
        if(dto.getPrice()<0.0){
            return new MessageResponse(false, "Product price not provided");
        }
        if(dto.getDiscount()<0.0){
            return new MessageResponse(false, "Product discount price not provided");
        }
        if(dto.getImage().isEmpty()){
            return new MessageResponse(false, "Product image not provided");
        }

        if(dto.getDescription().isEmpty()){
            return new MessageResponse(false, "Product Description name not provided");
        }else {
            return new MessageResponse( "Product DescriptionSuccessfully validated");
        }

    }
    public static MessageResponse deletedValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }
        //        *********************is featured need to verify*******************************
        if(dto.isIs_featured()){
            return new MessageResponse(false, "Product name not provided");
        }
        if(dto.getPrice()<0.0){
            return new MessageResponse(false, "Product price not provided");
        }
        if(dto.getDiscount()<0.0){
            return new MessageResponse(false, "Product discount price not provided");
        }
        if(dto.getImage().isEmpty()){
            return new MessageResponse(false, "Product image not provided");
        }

        if(dto.getDescription().isEmpty()){
            return new MessageResponse(false, "Product Description name not provided");
        }else {
            return new MessageResponse( "Product DescriptionSuccessfully validated");
        }


}
}

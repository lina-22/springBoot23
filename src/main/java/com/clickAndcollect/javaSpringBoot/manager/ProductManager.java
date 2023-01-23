package com.clickAndcollect.javaSpringBoot.manager;

import com.clickAndcollect.javaSpringBoot.dto.ProductDto;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;

public class ProductManager {

    public static MessageResponse validation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }else {
            return new MessageResponse("Product name Successfully validated");
        }
        //        *********************is featured need to verify*******************************
//        if(dto.isIs_featured()){
//            return new MessageResponse(false, "Product name not provided");
//        }else {
//            return new MessageResponse("Successfully validated");
//        }
//        if(dto.getPrice().toString().isEmpty()){
//            return new MessageResponse(false, "Product price not provided");
//        }else {
//            return new MessageResponse("Product price Successfully validated");
//        }
//        if(dto.getDiscount().toString().isEmpty()){
//            return new MessageResponse(false, "Product discount price not provided");
//        }else {
//            return new MessageResponse(" Product discount price Successfully validated");
//        }
//        if(dto.getImage().isEmpty()){
//            return new MessageResponse(false, "Product image not provided");
//        }else {
//            return new MessageResponse("Product image Successfully validated");
//        }

//        if(dto.getDescription().isEmpty()){
//            return new MessageResponse(false, "Product Description name not provided");
//        }else {
//            return new MessageResponse( "Product DescriptionSuccessfully validated");
//        }

    }

    public static MessageResponse readValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }else {
            return new MessageResponse("Product name Successfully validated");
        }
        //        *********************is featured need to verify*******************************
//        if(dto.isIs_featured()){
//            return new MessageResponse(false, "Product name not provided");
//        }else {
//            return new MessageResponse("Successfully validated");
//        }
//        if(dto.getPrice().toString().isEmpty()){
//            return new MessageResponse(false, "Product price not provided");
//        }else {
//            return new MessageResponse("Product price Successfully validated");
//        }
//        if(dto.getDiscount().toString().isEmpty()){
//            return new MessageResponse(false, "Product discount price not provided");
//        }else {
//            return new MessageResponse(" Product discount price Successfully validated");
//        }
//        if(dto.getImage().isEmpty()){
//            return new MessageResponse(false, "Product image not provided");
//        }else {
//            return new MessageResponse("Product image Successfully validated");
//        }

//        if(dto.getDescription().isEmpty()){
//            return new MessageResponse(false, "Product Description name not provided");
//        }else {
//            return new MessageResponse( "Product DescriptionSuccessfully validated");
//        }

    }

    public static MessageResponse updatedValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }else {
            return new MessageResponse("Product name Successfully validated");
        }
        //        *********************is featured need to verify*******************************
//        if(dto.isIs_featured()){
//            return new MessageResponse(false, "Product name not provided");
//        }else {
//            return new MessageResponse("Successfully validated");
//        }
//        if(dto.getPrice().toString().isEmpty()){
//            return new MessageResponse(false, "Product price not provided");
//        }else {
//            return new MessageResponse("Product price Successfully validated");
//        }
//        if(dto.getDiscount().toString().isEmpty()){
//            return new MessageResponse(false, "Product discount price not provided");
//        }else {
//            return new MessageResponse(" Product discount price Successfully validated");
//        }
//        if(dto.getImage().isEmpty()){
//            return new MessageResponse(false, "Product image not provided");
//        }else {
//            return new MessageResponse("Product image Successfully validated");
//        }

//        if(dto.getDescription().isEmpty()){
//            return new MessageResponse(false, "Product Description name not provided");
//        }else {
//            return new MessageResponse( "Product DescriptionSuccessfully validated");
//        }

    }
    public static MessageResponse deletedValidation(ProductDto dto){
        if(dto.getId().toString().isEmpty()){
            return new MessageResponse(false, "Product id not provided");
        }

        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Product name not provided");
        }else {
            return new MessageResponse("Product name Successfully validated");
        }
        //        *********************is featured need to verify*******************************
//        if(dto.isIs_featured()){
//            return new MessageResponse(false, "Product name not provided");
//        }else {
//            return new MessageResponse("Successfully validated");
//        }
//        if(dto.getPrice().toString().isEmpty()){
//            return new MessageResponse(false, "Product price not provided");
//        }else {
//            return new MessageResponse("Product price Successfully validated");
//        }
//        if(dto.getDiscount().toString().isEmpty()){
//            return new MessageResponse(false, "Product discount price not provided");
//        }else {
//            return new MessageResponse(" Product discount price Successfully validated");
//        }
//        if(dto.getImage().isEmpty()){
//            return new MessageResponse(false, "Product image not provided");
//        }else {
//            return new MessageResponse("Product image Successfully validated");
//        }

//        if(dto.getDescription().isEmpty()){
//            return new MessageResponse(false, "Product Description name not provided");
//        }else {
//            return new MessageResponse( "Product DescriptionSuccessfully validated");
//        }


}
}

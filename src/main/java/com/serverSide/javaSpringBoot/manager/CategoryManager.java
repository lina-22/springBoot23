package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.response.MessageResponse;

public class CategoryManager {
    public static MessageResponse validation(CategoryDto dto){
        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Category name not provided");
        }else {
            return new MessageResponse("Successfully validated");
        }
    }

    public static MessageResponse readValidation(CategoryDto dto){
        if(dto.getId().isEmpty()){
            return new MessageResponse(false, "Category id not provided");
        }else {
            return new MessageResponse("Successfully validated");
        }
    }
    public static MessageResponse updatedValidation(CategoryDto dto){
        if(dto.getId().isEmpty()){
            return new MessageResponse(false, "Category id not provided");
        }
        if(dto.getName().isEmpty()){
            return new MessageResponse(false, "Category name not provided");
        }else {
            return new MessageResponse("Successfully validated");
        }
    }
    public static MessageResponse deletedValidation(CategoryDto dto){
        if(dto.getId().isEmpty()){
            return new MessageResponse(false, "Category id not provided");
        }else {
            return new MessageResponse("Successfully validated");
        }
    }


}
package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.AvailableProductDto;
import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;

public class AvailableProductManager {




    // ******************* the dto to model data transfer****************
    public AvailableProductModel toAvailableProductModel(AvailableProductDto availableProductDto){
        AvailableProductModel availableProductModel = new AvailableProductModel();
        availableProductModel.setColour(availableProductDto.getColour());
        availableProductModel.setQuantity(availableProductDto.getQuantity());
        availableProductModel.setSize(availableProductDto.getSize());

        return availableProductModel;
    }

    public AvailableProductDto toAvailableProductDto(AvailableProductModel availableProductModel){
        AvailableProductDto availableProductDto = new AvailableProductDto();
        availableProductDto.setId(availableProductModel.getId());
        availableProductDto.setColour(availableProductModel.getColour());
        availableProductDto.setQuantity(availableProductModel.getQuantity());
        availableProductDto.setSize(availableProductModel.getSize());

        return  availableProductDto;
    }


    // *******************the dto to model data transfer****************

}

package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.AvailableProductDto;
import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.response.MessageResponse;
import com.serverSide.javaSpringBoot.services.AvailableProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AvailableProductManager {

    private AvailableProductService availableProductService;
   /* public AvailableProductDto createAvailableProduct(AvailableProductDto  availableProductDto){
        AvailableProductModel availableProductToAdd = toAvailableProductModel( availableProductDto);
        AvailableProductModel addedAvailableProduct =  availableProductService.create( availableProductToAdd);

        return toAvailableProductDto(addedAvailableProduct);

    }


    public List<AvailableProductDto> getAllAvailableProduct() {
        List<AvailableProductDto>availableProductDtoList = new ArrayList<>();
        List<AvailableProductModel> availableProductModelList = availableProductService.findAll();
        availableProductModelList.forEach(data-> {
            availableProductDtoList.add(toAvailableProductDto(data));
        });
        return availableProductDtoList;
    }*/

    // ******************* the dto to model data transfer****************
    /*public AvailableProductModel toAvailableProductModel(AvailableProductDto availableProductDto){
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
    }*/


    // *******************the dto to model data transfer****************

}

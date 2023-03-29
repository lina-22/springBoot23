package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.AvailableProductDtoRes;
import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.services.AvailableProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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
    public AvailableProductDtoRes toDto(AvailableProductModel availableProductModel){

        AvailableProductDtoRes availableProductDtoRes = new AvailableProductDtoRes();

        availableProductDtoRes.setId(availableProductModel.getApId());
        availableProductDtoRes.setQty(availableProductModel.getApQuantity());
        availableProductDtoRes.setSkuReference(availableProductModel.getSkuReference());
        availableProductDtoRes.setSize(availableProductModel.getSizeModel().getSizeValue());
        availableProductDtoRes.setCategory(availableProductModel.getCategoryModel().getCategoryValue());
        availableProductDtoRes.setColour(availableProductModel.getColourModel().getColourValue());
        availableProductDtoRes.setMaterial(availableProductModel.getMaterialModel().getMaterialValue());

        return availableProductDtoRes;
    }

    public Set<AvailableProductDtoRes> toDtos(Set<AvailableProductModel>availableProductModels){

        //Set<AvailableProductModel>availableProductDtoSet = new HashSet<>(availableProductModels);

        Set<AvailableProductDtoRes> availableProductDtoRespons = new HashSet<>();

        availableProductModels.forEach(data->{
          availableProductDtoRespons.add(toDto(data));
        });
        return availableProductDtoRespons;
    }
}

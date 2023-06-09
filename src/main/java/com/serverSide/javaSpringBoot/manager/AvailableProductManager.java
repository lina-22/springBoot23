package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.AvailableProductResDto;
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
    public AvailableProductResDto toDto(AvailableProductModel availableProductModel){

        AvailableProductResDto availableProductResDto = new AvailableProductResDto();
        availableProductResDto.setId(availableProductModel.getApId());
        availableProductResDto.setQty(availableProductModel.getApQuantity());
        availableProductResDto.setSkuReference(availableProductModel.getSkuReference());

        availableProductResDto.setSize(availableProductModel.getSizeModel().getSizeValue());

        availableProductResDto.setCategory(availableProductModel.getCategoryModel().getCategoryValue());

        availableProductResDto.setColour(availableProductModel.getColourModel().getColourValue());
        availableProductResDto.setMaterial(availableProductModel.getMaterialModel().getMaterialValue());
        return availableProductResDto;
    }

    public Set<AvailableProductResDto> toDtos(Set<AvailableProductModel>availableProductModels){
        Set<AvailableProductResDto> availableProductResponDtos = new HashSet<>();
        availableProductModels.forEach(data->{
          availableProductResponDtos.add(toDto(data));
        });
        return availableProductResponDtos;
    }
}

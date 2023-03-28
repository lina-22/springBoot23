package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.model.MaterialModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.services.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaterialManager {
    private MaterialService materialService;

    public MaterialDto createMaterial(MaterialDto materialDto){
        MaterialModel materialToAdd = toMaterialModel(materialDto);
        MaterialModel addedMaterial = materialService.create(materialToAdd);
        return toMaterialDto(addedMaterial);
    }


    public List<MaterialDto> getAllMaterial(){
        List<MaterialDto>materialDtoList = new ArrayList<>();
        List<MaterialModel>materialModelList = materialService.findAll();
        materialModelList.forEach(data->{
            materialDtoList.add(toMaterialDto(data));
        });
        return materialDtoList;
    }


    public MaterialDto updateMaterial(MaterialDto materialDto){
        Optional<MaterialModel> materialModel =  materialService.findById(materialDto.getMaterial_id());
        if (materialModel.isPresent()){
            materialModel.get().setMaterial_value(materialDto.getMaterial_value());
            MaterialModel updatedMaterialModel =  materialService.update(materialModel.get());
            return toMaterialDto(updatedMaterialModel);
        }
        return new MaterialDto();

    }
    // ******************* the dto to model data transfer****************

    public MaterialModel toMaterialModel(MaterialDto materialDto){
        MaterialModel materialModel = new MaterialModel();
        materialModel.setMaterial_value(materialDto.getMaterial_value());
        return materialModel;
    }

    public MaterialDto toMaterialDto(MaterialModel materialModel){
        MaterialDto materialDto = new MaterialDto();
        materialDto.setMaterial_id(materialModel.getMaterial_id());
        materialDto.setMaterial_value(materialModel.getMaterial_value());
        return  materialDto;
    }
}
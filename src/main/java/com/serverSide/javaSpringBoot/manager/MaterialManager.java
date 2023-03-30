package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.model.MaterialModel;
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


    public MaterialDto getMaterialById(long material_id){
        return toMaterialDto(materialService.findById(material_id).get());
    }

    public MaterialDto updateMaterial(MaterialDto materialDto){
        Optional<MaterialModel> materialModel =  materialService.findById(materialDto.getMaterialId());
        if (materialModel.isPresent()){
            materialModel.get().setMaterialValue(materialDto.getMaterialValue());
            MaterialModel updatedMaterialModel =  materialService.update(materialModel.get());
            return toMaterialDto(updatedMaterialModel);
        }
        return new MaterialDto();

    }

    public void deleteMaterialById(long material_id){

        materialService.delete(material_id);
    }
    // ******************* the dto to model data transfer****************

    public MaterialModel toMaterialModel(MaterialDto materialDto){
        MaterialModel materialModel = new MaterialModel();
        materialModel.setMaterialValue(materialDto.getMaterialValue());
        return materialModel;
    }

    public MaterialDto toMaterialDto(MaterialModel materialModel){
        MaterialDto materialDto = new MaterialDto();
        materialDto.setMaterialId(materialModel.getMaterialId());
        materialDto.setMaterialValue(materialModel.getMaterialValue());
        return  materialDto;
    }
}

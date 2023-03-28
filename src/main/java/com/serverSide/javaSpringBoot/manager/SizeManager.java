package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.model.MaterialModel;
import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.services.SizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SizeManager {

    private SizeService sizeService;

    public SizeDto createSize(SizeDto sizeDto){
        SizeModel sizeToAdd = toSizeModel(sizeDto);
        SizeModel addedSize = sizeService.create(sizeToAdd);
        return toSizeDto(addedSize);
    }


    public List<SizeDto> getAllSize(){
        List<SizeDto>sizeDtoList = new ArrayList<>();
        List<SizeModel>sizeModelList = sizeService.findAll();
        sizeModelList.forEach(data->{
            sizeDtoList.add(toSizeDto(data));
        });
        return sizeDtoList;
    }

    public SizeDto getSizeById(long size_id){
        return toSizeDto(sizeService.findById(size_id).get());
    }

    public SizeDto updateSize(SizeDto sizeDto){
        Optional<SizeModel> sizeModel =  sizeService.findById(sizeDto.getSize_id());
        if (sizeModel.isPresent()){
            sizeModel.get().setSize_value(sizeDto.getSize_value());
            SizeModel updatedSizeModel =  sizeService.update(sizeModel.get());
            return toSizeDto(updatedSizeModel);
        }
        return new SizeDto();

    }
    // ******************* the dto to model data transfer****************

    public SizeModel toSizeModel(SizeDto sizeDto){
           SizeModel sizeModel = new SizeModel();
           sizeModel.setSize_value(sizeDto.getSize_value());
           return sizeModel;
    }

    public SizeDto toSizeDto(SizeModel sizeModel){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setSize_id(sizeModel.getSize_id());
        sizeDto.setSize_value(sizeModel.getSize_value());
        return  sizeDto;
    }
}

package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.services.SizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SizeManager {

    private SizeService sizeService;

    public SizeDto createSize(SizeDto sizeDto){
        SizeModel sizeToAdd = toSizeModel(sizeDto);
        SizeModel addedSize = sizeService.create(sizeToAdd);
        return toSizeDto(addedSize);
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

package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.services.ColourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColourManager {
    private ColourService colourService;


    public ColourDto createColour(ColourDto colourDto){
        ColourModel colourToAdd = toColourModel(colourDto);
        ColourModel addedColour = colourService.create(colourToAdd);
        return toColourDto(addedColour);
    }


    public List<ColourDto> getAllColour(){
        List<ColourDto>colourDtoList = new ArrayList<>();
        List<ColourModel>colourModelList = colourService.findAll();
        colourModelList.forEach(data->{
            colourDtoList.add(toColourDto(data));
        });
        return colourDtoList;
    }

    public ColourDto getColourById(long colour_id){
        return toColourDto(colourService.findById(colour_id).get());
    }


    public ColourDto updateColour(ColourDto colourDto){
        Optional<ColourModel> colourModel =  colourService.findById(colourDto.getColour_id());
        if (colourModel.isPresent()){
            colourModel.get().setColour_value(colourDto.getColour_value());
            ColourModel updatedColourModel =  colourService.update(colourModel.get());
            return toColourDto(updatedColourModel);
        }
        return new ColourDto();

    }
    // ******************* the dto to model data transfer****************

    public ColourModel toColourModel(ColourDto colourDto){
        ColourModel colourModel = new ColourModel();
        colourModel.setColour_value(colourDto.getColour_value());
        return colourModel;
    }

    public ColourDto toColourDto(ColourModel colourModel){
        ColourDto colourDto = new ColourDto();
        colourDto.setColour_id(colourModel.getColour_id());
        colourDto.setColour_value(colourModel.getColour_value());
        return  colourDto;
    }
}

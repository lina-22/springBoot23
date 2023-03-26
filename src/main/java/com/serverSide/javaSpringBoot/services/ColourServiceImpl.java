package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.repository.ColourRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class ColourServiceImpl implements ColourService {

    private ColourRepository colourRepository;

    @Override
    public ColourModel create(ColourModel colourModel) {
        return colourRepository.save(colourModel);
    }

    @Override
    public Optional<ColourModel> findById(long colour_id) {
        return colourRepository.findById(colour_id);
    }

    @Override
    public List<ColourModel> findAll() {
        return colourRepository.findAll();
    }

    @Override
    public ColourModel update(ColourModel colourModel) {
        return colourRepository.saveAndFlush(colourModel);
    }

    @Override
    public void delete(long colour_id) {
        colourRepository.deleteById(colour_id);
    }

}

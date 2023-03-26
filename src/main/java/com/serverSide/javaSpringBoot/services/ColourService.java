package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ColourModel;

import java.util.List;
import java.util.Optional;

public interface ColourService {

    public ColourModel create(ColourModel colourModel);
    public Optional<ColourModel> findById(long colour_id);

    public List<ColourModel> findAll();

    public ColourModel update(ColourModel colourModel);

    public  void delete(long colour_id);
}

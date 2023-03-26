package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.MaterialModel;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    public MaterialModel create(MaterialModel materialModel);
    public Optional<MaterialModel> findById(long material_id);

    public List<MaterialModel> findAll();

    public MaterialModel update(MaterialModel materialModel);

    public  void delete(long material_id);
}

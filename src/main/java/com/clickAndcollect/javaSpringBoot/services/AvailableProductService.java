package com.clickAndcollect.javaSpringBoot.services;

import com.clickAndcollect.javaSpringBoot.model.AvailableProductModel;

import java.util.List;
import java.util.Optional;

public interface AvailableProductService {

    public AvailableProductModel insert(AvailableProductModel availableProductModel);

    public AvailableProductModel update(AvailableProductModel availableProductModel);

    public Optional<AvailableProductModel> findById(Long id);

    public List<AvailableProductModel> findAll();
}

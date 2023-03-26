package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.AvailableProductModel;

import java.util.List;
import java.util.Optional;

public interface AvailableProductService {

    public AvailableProductModel create(AvailableProductModel availableProductModel);

    public AvailableProductModel update(AvailableProductModel availableProductModel);

    public Optional<AvailableProductModel> findById(long ap_id);

    public List<AvailableProductModel> findAll();

    public  void delete(long ap_id);
}

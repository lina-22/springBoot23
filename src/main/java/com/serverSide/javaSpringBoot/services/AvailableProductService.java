package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.AvailableProductModel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AvailableProductService {

     AvailableProductModel createAndUpdate(AvailableProductModel availableProductModel);

    Set<AvailableProductModel> saveAll(List<AvailableProductModel> availableProductModels);

     AvailableProductModel update(AvailableProductModel availableProductModel);

     Optional<AvailableProductModel> findById(long ap_id);

     List<AvailableProductModel> findAll();

      void delete(long ap_id);
}

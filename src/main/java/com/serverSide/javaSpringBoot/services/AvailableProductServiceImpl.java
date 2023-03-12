package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.repository.AvailableProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AvailableProductServiceImpl implements AvailableProductService {

    @Autowired
    AvailableProductRepository mAvailableProductRepository;

    @Override
    public AvailableProductModel create(AvailableProductModel availableProductModel){
        return mAvailableProductRepository.save(availableProductModel);
    };

    @Override
    public AvailableProductModel update(AvailableProductModel availableProductModel){
        return mAvailableProductRepository.save(availableProductModel);
    };

    @Override
    public Optional<AvailableProductModel> findById(Long id){
        return mAvailableProductRepository.findById(id);
    };

    @Override
    public List<AvailableProductModel> findAll(){
        return mAvailableProductRepository.findAll();
    };
}

package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.repository.AvailableProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class AvailableProductServiceImpl implements AvailableProductService {

    @Autowired
    AvailableProductRepository mAvailableProductRepository;

    @Override
    public AvailableProductModel createAndUpdate(AvailableProductModel availableProductModel){
        return mAvailableProductRepository.save(availableProductModel);
    }

    @Override
    public Set<AvailableProductModel> saveAll(List<AvailableProductModel> availableProductModels) {
        mAvailableProductRepository.saveAll(availableProductModels);
        List<AvailableProductModel> savedAvailables = mAvailableProductRepository.saveAllAndFlush(availableProductModels);
        Set<AvailableProductModel>availableProductModelSet = new HashSet<>(savedAvailables);
        return  availableProductModelSet;
    }

    ;

    @Override
    public AvailableProductModel update(AvailableProductModel availableProductModel){
        return mAvailableProductRepository.save(availableProductModel);
    };

    @Override
    public Optional<AvailableProductModel> findById(long ap_id){
        return mAvailableProductRepository.findById(ap_id);
    };

    @Override
    public List<AvailableProductModel> findAll(){
        return mAvailableProductRepository.findAll();
    };

    @Override
    public void delete(long ap_id) {
        mAvailableProductRepository.deleteById(ap_id);
    }
}

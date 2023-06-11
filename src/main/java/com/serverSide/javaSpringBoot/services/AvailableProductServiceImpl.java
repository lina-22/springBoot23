package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import com.serverSide.javaSpringBoot.model.ReservationModel;
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
    };

    @Override
    public AvailableProductModel update(AvailableProductModel availableProductModel){
        return mAvailableProductRepository.save(availableProductModel);
    };

    @Override
    public Optional<AvailableProductModel> findById(long ap_id){

        System.out.println("test service : " + mAvailableProductRepository.findById(ap_id));
        return mAvailableProductRepository.findById(ap_id);
    };

    @Override
    public List<AvailableProductModel> findAll(){
        return mAvailableProductRepository.findAll();
    };

    @Override
    public List<AvailableProductModel> findAllByIds(List<Long> ids){
        return (List<AvailableProductModel>) mAvailableProductRepository.findAllById(ids);
    }

//    @Override
//    public List<ReservationModel> findAllByIds(List<Long> ids) {
//        return (List<ReservationModel>) mReservationRepository.findAllById(ids);
//    }

    @Override
    public void delete(long ap_id) {
        mAvailableProductRepository.deleteById(ap_id);
    }
}

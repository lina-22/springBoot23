package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ProductForSale;
import com.serverSide.javaSpringBoot.repository.ProductForSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ProductForSaleServiceImpl implements ProductForSaleService {

    @Autowired
    ProductForSaleRepository mProductForSaleRepository;

    @Override
    public ProductForSale createAndUpdate(ProductForSale productForSale){
        return mProductForSaleRepository.save(productForSale);
    }

    @Override
    public List<ProductForSale> saveAll(List<ProductForSale> productForSales) {
        mProductForSaleRepository.saveAll(productForSales);
        List<ProductForSale> savedAvailables = mProductForSaleRepository.saveAllAndFlush(productForSales);
        return savedAvailables;
    };

    @Override
    public ProductForSale update(ProductForSale productForSale){
        return mProductForSaleRepository.save(productForSale);
    };

    @Override
    public Optional<ProductForSale> findById(long ap_id){

        System.out.println("test service : " + mProductForSaleRepository.findById(ap_id));
        return mProductForSaleRepository.findById(ap_id);
    };

    @Override
    public List<ProductForSale> findAll(){
        return mProductForSaleRepository.findAll();
    };

    @Override
    public List<ProductForSale> findAllByIds(List<Long> ids){
        return (List<ProductForSale>) mProductForSaleRepository.findAllById(ids);
    }

//    @Override
//    public List<ReservationModel> findAllByIds(List<Long> ids) {
//        return (List<ReservationModel>) mReservationRepository.findAllById(ids);
//    }

    @Override
    public void delete(long ap_id) {
        mProductForSaleRepository.deleteById(ap_id);
    }
}

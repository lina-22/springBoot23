package com.clickAndcollect.javaSpringBoot.services;

import com.clickAndcollect.javaSpringBoot.model.ProductModel;
import com.clickAndcollect.javaSpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository mProductRepository;

    @Override
    public Optional<ProductModel> findById(Long id) {
       return mProductRepository.findById(id);
    }

    @Override
    public List<ProductModel> findAll() {
        return mProductRepository.findAll();
    }
}

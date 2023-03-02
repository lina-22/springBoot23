package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.repository.CategoryRepository;
import com.serverSide.javaSpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository mProductRepository;
    @Autowired
    CategoryRepository mCategoryRepo;

    @Override
    public ProductModel insert(ProductModel productModel){ // insert method productmodel variable and datatype ProductModel

        return  mProductRepository.saveAndFlush(productModel); // save and flush?

    }
    @Override
    public Optional<ProductModel> findById(Long id) {

        return mProductRepository.findById(id);
    }

    @Override
    public List<ProductModel> findAll() {

        return mProductRepository.findAll();
    }

    @Override
    public ProductModel update(ProductModel productModel){

        return  mProductRepository.save(productModel);
    }


    @Override
    public void delete(Long id) {
        mProductRepository.deleteById(id);
    }


    @Override
    public Optional<CategoryModel> isValidCategory(long id) { // <CategoryModal> or Optional data type?
        return mCategoryRepo.findById(Long.valueOf(id));
    }



}

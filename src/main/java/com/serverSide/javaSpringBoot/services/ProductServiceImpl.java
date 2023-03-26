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

    // autowired dependency injection
    // / productServiceIml class is depend on the productRepository
    // so i no need to do create object by new for the productRepository class
    @Autowired
    ProductRepository mProductRepository;
    //@Autowired
   // CategoryRepository mCategoryRepository;

    @Override
    public ProductModel create(ProductModel productModel){
        return  mProductRepository.save(productModel); //saveAndFlush ?
    }
    @Override
    public Optional<ProductModel> findById(long product_id) {

        return mProductRepository.findById(product_id);
    }

    @Override
    public List<ProductModel> findAll() {

        return mProductRepository.findAll();
    }

    @Override
    public ProductModel update(ProductModel productModel){
        System.out.println("test here :" + productModel.toString());
        return  mProductRepository.save(productModel);
    }


    @Override
    public void delete(long product_id) {
        mProductRepository.deleteById(product_id);
    }


    //@Override
    //public Optional<CategoryModel> isValidCategory(long id) { // <CategoryModal> or Optional data type?

      //  return mCategoryRepository.findById(Long.valueOf(id)); // valueOf ??
    //}



}

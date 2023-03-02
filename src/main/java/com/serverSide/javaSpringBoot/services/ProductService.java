package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public ProductModel insert(ProductModel productModel);
    public Optional<ProductModel> findById(Long id); // here i use optional because maybe find by id or not

    public List<ProductModel> findAll();

    public ProductModel update(ProductModel productModel);

    public  void delete(Long id);

    public Optional<CategoryModel> isValidCategory(long id); // get the category type
}

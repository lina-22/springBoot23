package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    // at Java always need to mention method datatype **ProductModel create ** and also variable datatype (ProductModel productModel)
    public ProductModel create(ProductModel productModel);
    public Optional<ProductModel> findById(long id); // here i use optional because maybe find by id or not

    public List<ProductModel> findAll();

    public ProductModel update(ProductModel productModel);

    public  void delete(long id);

    public Optional<CategoryModel> isValidCategory(long id); // get the category type??
}

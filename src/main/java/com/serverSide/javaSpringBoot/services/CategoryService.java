package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.CategoryModel;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public CategoryModel insert(CategoryModel categoryModel);
    public Optional<CategoryModel> findById(Long id);

    public List<CategoryModel> findAll();

    public CategoryModel update(CategoryModel categoryModel);


}

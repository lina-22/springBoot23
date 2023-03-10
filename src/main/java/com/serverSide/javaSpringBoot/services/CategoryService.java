package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.CategoryModel;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public CategoryModel create(CategoryModel categoryModel);
    public Optional<CategoryModel> findById(Long id);

    public List<CategoryModel> findAll();

    public CategoryModel update(CategoryModel categoryModel);

    public  void delete(long id);

    List<CategoryModel> findAllById(List<Long>ids);
}

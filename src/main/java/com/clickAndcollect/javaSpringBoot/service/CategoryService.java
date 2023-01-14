package com.clickAndcollect.javaSpringBoot.service;


import com.clickAndcollect.javaSpringBoot.model.CategoryModel;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

    public Optional<CategoryModel> findById(Long id);



    public List<CategoryModel> findAll();

    public CategoryModel update(CategoryModel categoryModel);

    public CategoryModel insert(CategoryModel categoryModel);



}

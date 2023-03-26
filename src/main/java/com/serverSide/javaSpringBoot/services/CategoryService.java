package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.CategoryModel;


import java.util.List;
import java.util.Optional;


public interface CategoryService {

     CategoryModel create(CategoryModel categoryModel);
     Optional<CategoryModel> findById(long category_id);

     List<CategoryModel> findAll();

     CategoryModel update(CategoryModel categoryModel);

      void delete(long category_id);

    //List<CategoryModel> findAllById(List<Long>ids); //
}

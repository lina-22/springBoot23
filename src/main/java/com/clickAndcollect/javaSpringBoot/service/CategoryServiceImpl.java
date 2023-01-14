package com.clickAndcollect.javaSpringBoot.service;

import com.clickAndcollect.javaSpringBoot.model.CategoryModel;
import com.clickAndcollect.javaSpringBoot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository mCategoryRepository;
    @Override
    public Optional<CategoryModel> findById(Long id){

        return mCategoryRepository.findById(id);
    }

    @Override
    public List<CategoryModel> findAll(){

        return mCategoryRepository.findAll();
    }
}


//agulu holo categoryService interface ar sob methods jegulu k ofcourse override kora nia ashby.
//
// public interface CategoryService {
//
//    public Optional<CategoryModel> findById(Long id);
//
//    public List<CategoryModel> findAll();
//
//}
package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository mCategoryRepository;


    @Override
    public CategoryModel create(CategoryModel categoryModel) {

        return mCategoryRepository.save(categoryModel);
    }

    @Override
    public Optional<CategoryModel> findById(long category_id) {

        return mCategoryRepository.findById(category_id);
    }

    @Override
    public List<CategoryModel> findAll() {

        return mCategoryRepository.findAll();
    }

    @Override
    public CategoryModel update(CategoryModel categoryModel) {
        return mCategoryRepository.saveAndFlush(categoryModel);
    }

    @Override
    public void delete(long category_id) {

        mCategoryRepository.deleteById(category_id);
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
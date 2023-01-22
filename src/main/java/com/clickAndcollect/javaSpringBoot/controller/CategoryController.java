package com.clickAndcollect.javaSpringBoot.controller;

import com.clickAndcollect.javaSpringBoot.dto.CategoryDto;
import com.clickAndcollect.javaSpringBoot.manager.CategoryManager;
import com.clickAndcollect.javaSpringBoot.model.CategoryModel;
import com.clickAndcollect.javaSpringBoot.response.MessageResponse;
import com.clickAndcollect.javaSpringBoot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
class CategoryController {
    @Autowired
    CategoryService mCategoryService;

    @PostMapping("create")
    ResponseEntity<?> create(@RequestBody CategoryDto dto){
        MessageResponse validation = CategoryManager.validation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setName(dto.getName());
            CategoryModel isSaved =  mCategoryService.insert(categoryModel);
            return ResponseEntity.ok(isSaved);

        }
    }

    @GetMapping("showOne")
    ResponseEntity<?> read(@RequestBody  CategoryDto dto){
        MessageResponse  validation = CategoryManager.readValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setName(dto.getId());
            categoryModel.setName(dto.getName());
            CategoryModel isSaved =  mCategoryService.update(categoryModel);
            return ResponseEntity.ok(isSaved);
        }
    }

    @GetMapping("showAll")
    ResponseEntity<?> showAll(){
        return ResponseEntity.ok(mCategoryService.findAll());
    }


    @PutMapping("update")
    ResponseEntity<?> update(@RequestBody  CategoryDto dto){
        MessageResponse  validation = CategoryManager.updatedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setName(dto.getId());
            categoryModel.setName(dto.getName());
            CategoryModel isSaved =  mCategoryService.update(categoryModel);
            return ResponseEntity.ok(isSaved);
        }
    }

    @PostMapping("delete")
    ResponseEntity<?> delete(@RequestBody  CategoryDto dto){
        MessageResponse  validation = CategoryManager.deletedValidation(dto);
        if(!validation.isSuccess()){
            return ResponseEntity.badRequest().body(validation);
        }else {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setName(dto.getId());
            categoryModel.setName(dto.getName());
            CategoryModel isSaved =  mCategoryService.update(categoryModel);
            return ResponseEntity.ok(isSaved);
        }
    }

}


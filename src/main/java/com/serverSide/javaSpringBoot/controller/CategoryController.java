package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.manager.CategoryManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
class CategoryController {
    private final CategoryManager categoryManager;
    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryManager.createCategory(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> getAllCategory(){
        return categoryManager.getAllCategory();
    }

    @GetMapping(path = "/{category_id}")
    public CategoryDto getCategoryById(@PathVariable long category_id){

        return categoryManager.getCategoryById(category_id);
    }

    @PutMapping
    public CategoryDto updateCategoryById(@RequestBody CategoryDto categoryDto){

        return categoryManager.updateCategory(categoryDto);
    }

  @GetMapping("/test")
    public String getAllCategoryTest(){
        return "tested ok";
    }


}

package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.manager.CategoryManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
class CategoryController {
    private final CategoryManager categoryManager;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryManager.createCategory(categoryDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CategoryDto> getAllCategory(){
        return categoryManager.getAllCategory();
    }

    @GetMapping(path = "/{category_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto getCategoryById(@PathVariable long category_id){

        return categoryManager.getCategoryById(category_id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto updateCategoryById(@RequestBody CategoryDto categoryDto){

        return categoryManager.updateCategory(categoryDto);
    }

    @DeleteMapping(path ="/{category_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategoryById(@PathVariable long category_id){
        try{
            categoryManager.deleteCategoryById(category_id);
            return new ResponseEntity<>("Category with id+ " + category_id + "has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Category with " + category_id + " not found", HttpStatus.NOT_FOUND);
        }
    }

  @GetMapping("/test")
    public String getAllCategoryTest(){
        return "tested ok";
    }


}

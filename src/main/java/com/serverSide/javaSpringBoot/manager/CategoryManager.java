package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CategoryManager {

    private CategoryService categoryService;


   public CategoryDto createCategory(CategoryDto categoryDto){
        CategoryModel categoryToAdd = toCategoryModel(categoryDto);

        CategoryModel addedCategory = categoryService.create(categoryToAdd);
//        System.out.println("hello"+addedCategory);
        return toCategoryDto(addedCategory);

    }


    public List<CategoryDto> getAllCategory() {
        List<CategoryDto>categoryDtoList = new ArrayList<>();
        List<CategoryModel> categoryModelList = categoryService.findAll();
        categoryModelList.forEach(data-> {
            categoryDtoList.add(toCategoryDto(data));
        });
        return categoryDtoList;
    }

    public CategoryDto getCategoryById(long categoryId){

        return toCategoryDto(categoryService.findById(categoryId).get());
    }

    public CategoryDto updateCategory(CategoryDto categoryDto){
        Optional<CategoryModel> categoryModel =  categoryService.findById(categoryDto.getCategoryId());
        if (categoryModel.isPresent()){
            categoryModel.get().setCategoryValue(categoryDto.getCategoryValue());
            CategoryModel updatedCategoryModel =  categoryService.update(categoryModel.get());
            return toCategoryDto(updatedCategoryModel);
        }
        return new CategoryDto();

    }


    // ******************* the dto to model data transfer****************
   public CategoryModel toCategoryModel(CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryValue(categoryDto.getCategoryValue());
        return categoryModel;
    }

    public CategoryDto toCategoryDto(CategoryModel categoryModel){
         CategoryDto categoryDto = new CategoryDto();
         categoryDto.setCategoryId(categoryModel.getCategoryId());
         categoryDto.setCategoryValue(categoryModel.getCategoryValue());
        return  categoryDto;
    }


    // *******************the dto to model data transfer****************
}

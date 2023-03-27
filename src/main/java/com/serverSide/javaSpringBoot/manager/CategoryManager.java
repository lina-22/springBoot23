package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.services.CategoryService;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    // ******************* the dto to model data transfer****************
   public CategoryModel toCategoryModel( CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategory_value(categoryDto.getCategory_value());

        return categoryModel;
    }

    public CategoryDto toCategoryDto(CategoryModel categoryModel){
        CategoryDto categoryDto = new CategoryDto();
       categoryDto.setCategory_id(categoryModel.getCategory_id());
         categoryDto.setCategory_value(categoryModel.getCategory_value());

        return  categoryDto;
    }


    // *******************the dto to model data transfer****************
}

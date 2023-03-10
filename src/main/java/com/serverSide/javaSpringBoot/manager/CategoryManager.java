package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.CategoryDto;
import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.services.CategoryService;
import com.serverSide.javaSpringBoot.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryManager {

    private CategoryService categoryService;

    private ProductService productService;

    public CategoryDto createCategory(CategoryDto categoryDto){
        CategoryModel categoryToAdd = toCategoryModel(categoryDto);

        CategoryModel addedCategory = categoryService.create(categoryToAdd);

        return toCategoryDto(addedCategory);

    }

    // ******************* the dto to model data transfer****************
    public CategoryModel toCategoryModel( CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName(categoryDto.getName());

        return categoryModel;
    }

    public CategoryDto toCategoryDto(CategoryModel categoryModel){
        CategoryDto categoryDto = new CategoryDto();
       categoryDto.setId(categoryModel.getId());
         categoryDto.setName(categoryModel.getName());

        return  categoryDto;
    }


    // *******************the dto to model data transfer****************
}

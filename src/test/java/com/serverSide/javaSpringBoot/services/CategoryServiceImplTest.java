package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository mCategoryRepository;

    @InjectMocks
    private CategoryServiceImpl underTest;

    @Test
    void ShouldCreate() {
        //given -
        CategoryModel categoryModel = new CategoryModel(1, "F", null);
        given(mCategoryRepository.save(categoryModel)).willReturn(categoryModel);

        //when -
        CategoryModel result = underTest.create(categoryModel);

        //then -
        verify(mCategoryRepository, times(1)).save(categoryModel);
        assertThat(result).isNotNull();
        assertThat(result.getCategoryValue()).isEqualTo("F");
    }

    @Test
    void findById() {
        //given -
        long categoryId =1;
        CategoryModel categoryModel = new  CategoryModel(1, "F", null);
        given(mCategoryRepository.findById(categoryId)).willReturn(Optional.of(categoryModel));

        //when -
        Optional<CategoryModel> result= underTest.findById(categoryId);

        //then -

        verify(mCategoryRepository, times(1)).findById(categoryId);
        assertThat(result).isNotNull();
        assertThat(result.get().getCategoryValue()).isEqualTo("F");
    }

    @Test
    void findAll() {
        //given -
        CategoryModel categoryModel1 = new  CategoryModel(1, "F", null);
        CategoryModel categoryModel2 = new  CategoryModel(1, "F", null);
        CategoryModel categoryModel3 = new  CategoryModel(1, "F", null);
        List<CategoryModel>categoryModels = new ArrayList<>(Arrays.asList(categoryModel1, categoryModel2, categoryModel3));
        given(mCategoryRepository.findAll()).willReturn(categoryModels);

        //when -
        List<CategoryModel> result = underTest.findAll();

        //then -
        verify(mCategoryRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }

    @Test
    void shouldUpdate() {
        //given -
        CategoryModel categoryModel = new CategoryModel(1, "F", null);
        given(mCategoryRepository.saveAndFlush(categoryModel)).willReturn(categoryModel);

        //when -
        CategoryModel result= underTest.update(categoryModel);

        //then -

        verify(mCategoryRepository, times(1)).saveAndFlush(categoryModel);
        assertThat(result).isNotNull();
    }

    @Test
    void delete() {
        //given -
        long categoryId =1;

        //when -
        underTest.delete(categoryId);

        //then -
        verify(mCategoryRepository, times(1)).deleteById(categoryId);
    }
}
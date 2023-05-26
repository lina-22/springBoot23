package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.MaterialModel;
import com.serverSide.javaSpringBoot.repository.MaterialRepository;
import com.serverSide.javaSpringBoot.repository.MaterialRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class MaterialServiceImplTest {

    @Mock
    private MaterialRepository materialRepository;

    @InjectMocks
    private MaterialServiceImpl underTest;

    @Test
    void shouldCreate() {
        //given -
        MaterialModel materialModel = new MaterialModel(1, "S", null);
        given(materialRepository.save(materialModel)).willReturn(materialModel);

        //when -
        MaterialModel result = underTest.create(materialModel);

        //then -
        verify(materialRepository, times(1)).save(materialModel);
        assertThat(result).isNotNull();
        assertThat(result.getMaterialValue()).isEqualTo("S");
    }

    @Test
    void shouldFindById() {
        //given -
        long materialId = 1;
        MaterialModel materialModel = new MaterialModel(1, "S", null);
        given(materialRepository.findById(materialId)).willReturn(Optional.of(materialModel));

        //when -
        Optional<MaterialModel> result = underTest.findById(materialId);

        //then -
        verify(materialRepository, times(1)).findById(materialId);
        assertThat(result.get()).isNotNull();
        assertThat(result.get().getMaterialValue()).isEqualTo("S");
    }

    @Test
    @Disabled
    void shouldFindAll() {

        //given -
        MaterialModel materialModel1 = new MaterialModel(1, "S", null);
        MaterialModel materialModel2 = new MaterialModel(2, "S", null);
        MaterialModel materialModel3 = new MaterialModel(3, "S", null);
        List<MaterialModel> materialModels = new ArrayList<>(Arrays.asList(materialModel1, materialModel2, materialModel3));
        given(materialRepository.findAll()).willReturn(materialModels);

        //when -
        List<MaterialModel> result = underTest.findAll();

        //then -
        verify(materialRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }

    @Test
    void shouldUpdate() {
        //given -
        MaterialModel materialModel = new MaterialModel(1, "S", null);
        given(materialRepository.save(materialModel)).willReturn(materialModel);

        //when -
        MaterialModel result = underTest.update(materialModel);

        //then -
        verify(materialRepository, times(1)).save(materialModel);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDelete() {

        //given -
        long materialId = 1;

        //when -
        doNothing().when(materialRepository).deleteById(materialId);
        underTest.delete(materialId);

        //then -
        verify(materialRepository, times(1)).deleteById(materialId);
    }
}
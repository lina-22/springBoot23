package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.repository.ColourRepository;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ColourServiceImplTest {
    @Mock
    private ColourRepository colourRepository;

    @InjectMocks
    private ColourServiceImpl underTest;

    @Test
    void shouldCreate() {
        //given -
        ColourModel colourModel = new ColourModel(1, "S", null);
        given(colourRepository.save(colourModel)).willReturn(colourModel);

        //when -
        ColourModel result = underTest.create(colourModel);

        //then -
        verify(colourRepository, times(1)).save(colourModel);
        assertThat(result).isNotNull();
        assertThat(result.getColourValue()).isEqualTo("S");
    }

    @Test
    void shouldFindById() {
        //given -
        long sizeId = 1;
        ColourModel colourModel = new ColourModel(1, "S", null);
        given(colourRepository.findById(sizeId)).willReturn(Optional.of(colourModel));

        //when -
        Optional<ColourModel> result = underTest.findById(sizeId);

        //then -
        verify(colourRepository, times(1)).findById(sizeId);
        assertThat(result.get()).isNotNull();
        assertThat(result.get().getColourValue()).isEqualTo("S");
    }

    @Test
    void shouldFindAll() {

        //given -
        ColourModel colourModel1 = new ColourModel(1, "S", null);
        ColourModel colourModel2 = new ColourModel(2, "S", null);
        ColourModel colourModel3 = new ColourModel(3, "S", null);
        List<ColourModel>colourModels = new ArrayList<>(Arrays.asList(colourModel1, colourModel2, colourModel3));
        given(colourRepository.findAll()).willReturn(colourModels);

        //when -
        List<ColourModel> result = underTest.findAll();

        //then -
        verify(colourRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }

    @Test
    void shouldUpdate() {
        //given -
        ColourModel colourModel = new ColourModel(1, "S", null);
        given(colourRepository.saveAndFlush(colourModel)).willReturn(colourModel);

        //when -
        ColourModel result = underTest.update(colourModel);

        //then -
        verify(colourRepository, times(1)).saveAndFlush(colourModel);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDelete() {

        //given -
        long colourId = 1;

        //when -
        doNothing().when(colourRepository).deleteById(colourId);
        underTest.delete(colourId);

        //then -
        verify(colourRepository, times(1)).deleteById(colourId);
    }
}
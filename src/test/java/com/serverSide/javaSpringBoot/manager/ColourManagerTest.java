package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.*;
import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.dto.ColourDto;
import com.serverSide.javaSpringBoot.model.*;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.services.ColourService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ColourManagerTest {
    @Mock
    private ColourService colourService;

    @Mock
    private ColourManager colourManager;

    @InjectMocks
    private ColourManager underTest;

    @Test
    @Disabled
    void shouldCreateColour() {

        //given -
        ColourDto colourDto = new ColourDto(1, "S");
        ColourModel colourModel = new ColourModel(1, "S", null);
        given(colourService.create(colourModel)).willReturn(colourModel);
        when(colourManager.toColourDto(colourModel)).thenReturn(colourDto);

        //when -
        ColourDto result = underTest.createColour(colourDto);

        //then -
        assertThat(result).isNotNull();
    }

    @Test
    void shouldGetAllColour() {

        //given -
        List<ColourDto> colourDtoList = new ArrayList<>();
        ColourDto colourDto1 = new ColourDto(1, "S");
        ColourDto colourDto2 = new ColourDto(2, "M");
        colourDtoList.addAll(Arrays.asList(colourDto1, colourDto2));

        List<ColourModel>colourModelList = new ArrayList<>();
        ColourModel colourModel1 = new ColourModel(1, "S", null);
        ColourModel colourModel2 = new ColourModel(2, "M", null);
        colourModelList.addAll(Arrays.asList(colourModel1, colourModel2));

        given(colourService.findAll()).willReturn(colourModelList);

        //when -
        List<ColourDto>result = underTest.getAllColour();

        //then -
        assertThat(result).isNotNull();
    }

    @Test
    void shouldGetColourById() {

        //given -
        long colourId = 1;
        ColourModel colourModel = new ColourModel(1, "S", null);

        given(colourService.findById(colourId)).willReturn(Optional.of(colourModel));
        //when -

        ColourDto result = underTest.getColourById(colourId);

        //then -
        assertThat(result).isNotNull();
    }

    @Test
    void shouldUpdateColour() {

        //given -
        long colourId = 1;
        ColourModel colourModel = new ColourModel(1, "S", null);
        ColourDto colourDto = new ColourDto(1, "S");
        given(colourService.findById(colourId)).willReturn(Optional.of(colourModel));
        given(colourService.update(colourModel)).willReturn(colourModel);


        //when -
        ColourDto result = underTest.updateColour(colourDto);

        //then -
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDeleteColourById() {

        //given -
        long colourId = 1;

        //when -
        underTest.deleteColourById(colourId);

        //then -
        verify(colourService).delete(colourId);
    }

    @Test
    void shouldConvertToColourModel() {

        //given -
        ColourDto colourDto = new ColourDto(1L, "S");

        //when -
        ColourModel result = underTest.toColourModel(colourDto);

        //then -
        assertThat(result).isNotNull();
        assertThat(result.getColourValue()).isEqualTo("S");
    }

    @Test
    void shouldConvertToColourDto() {

        ColourModel colourModel = new ColourModel(1, "S", null);
        //given -

        //when -
        ColourDto result = underTest.toColourDto(colourModel);

        //then -
        assertThat(result).isNotNull();
        assertThat(result.getColourValue()).isEqualTo("S");
    }
}
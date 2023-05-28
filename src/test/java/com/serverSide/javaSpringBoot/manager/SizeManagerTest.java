package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.services.SizeService;

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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class SizeManagerTest {

    @Mock
    private SizeService sizeService;
    @Mock
    private SizeManager sizeManager;
    @InjectMocks
    private SizeManager underTest;

    @Test
    @Disabled
    void shouldCreateSize() {

        //given -
        SizeDto sizeDto = new SizeDto(1, "S");
        SizeModel sizeModel = new SizeModel(1, "S", null);
        given(sizeService.create(sizeModel)).willReturn(sizeModel);
        when(sizeManager.toSizeDto(sizeModel)).thenReturn(sizeDto);

        //when -
        SizeDto result = underTest.createSize(sizeDto);

        //then -
        assertThat(result).isNotNull();

    }

    @Test
    void shouldGetAllSize() {
        //given -
        List<SizeDto>sizeDtoList = new ArrayList<>();
        SizeDto sizeDto1 = new SizeDto(1, "S");
        SizeDto sizeDto2 = new SizeDto(2, "M");
        sizeDtoList.addAll(Arrays.asList(sizeDto1, sizeDto2));

        List<SizeModel>sizeModelList = new ArrayList<>();
        SizeModel sizeModel1 = new SizeModel(1, "S", null);
        SizeModel sizeModel2 = new SizeModel(2, "M", null);
        sizeModelList.addAll(Arrays.asList(sizeModel1, sizeModel2));

        given(sizeService.findAll()).willReturn(sizeModelList);

        //when -
        List<SizeDto>result = underTest.getAllSize();

        //then -
        assertThat(result).isNotNull();

    }

    @Test
    void shouldGetSizeById() {
        //given -
        long sizeId = 1;
        SizeModel sizeModel = new SizeModel(1, "S", null);

        given(sizeService.findById(sizeId)).willReturn(Optional.of(sizeModel));
        //when -

        SizeDto result = underTest.getSizeById(sizeId);

        //then -
        assertThat(result).isNotNull();

    }

    @Test
    void shouldUpdateSize() {
        //given -
        long sizeId = 1;
        SizeModel sizeModel = new SizeModel(1, "S", null);
        SizeDto sizeDto = new SizeDto(1, "S");
        given(sizeService.findById(sizeId)).willReturn(Optional.of(sizeModel));
        given(sizeService.update(sizeModel)).willReturn(sizeModel);


        //when -
        SizeDto result = underTest.updateSize(sizeDto);

        //then -
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDeleteSizeById() {
        //given -
        long sizeId = 1;

        //when -
        underTest.deleteSizeById(sizeId);

        //then -
        verify(sizeService).delete(sizeId);

    }

    @Test
    void shouldConvertToSizeModel() {
        //given -
        SizeDto sizeDto = new SizeDto(1L, "S");

        //when -
        SizeModel result = underTest.toSizeModel(sizeDto);

        //then -
        assertThat(result).isNotNull();
        assertThat(result.getSizeValue()).isEqualTo("S");
    }

    @Test
    void shouldConvertToSizeDto() {
        SizeModel sizeModel = new SizeModel(1, "S", null);
        //given -

        //when -
        SizeDto result = underTest.toSizeDto(sizeModel);

        //then -
        assertThat(result).isNotNull();
        assertThat(result.getSizeValue()).isEqualTo("S");
    }
}
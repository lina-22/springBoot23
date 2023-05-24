package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.SizeModel;
import com.serverSide.javaSpringBoot.repository.SizeRepository;
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


@ExtendWith(SpringExtension.class)
class SizeServiceImplTest {

    @Mock
    private SizeRepository sizeRepository;
    @InjectMocks
    private SizeServiceImpl underTest;


    @Test
    void shouldCreate() {
        //given -
        SizeModel sizeModel = new SizeModel(1, "S", null);
        given(sizeRepository.save(sizeModel)).willReturn(sizeModel);

        //when -
        SizeModel result = underTest.create(sizeModel);

        //then -
        verify(sizeRepository, times(1)).save(sizeModel);
        assertThat(result).isNotNull();
        assertThat(result.getSizeValue()).isEqualTo("S");
    }

    @Test
    void shouldFindById() {
        //given -
        long sizeId = 1;
        SizeModel sizeModel = new SizeModel(1, "S", null);
        given(sizeRepository.findById(sizeId)).willReturn(Optional.of(sizeModel));

        //when -
        Optional<SizeModel> result = underTest.findById(sizeId);

        //then -
        verify(sizeRepository, times(1)).findById(sizeId);
        assertThat(result.get()).isNotNull();
        assertThat(result.get().getSizeValue()).isEqualTo("S");
    }

    @Test
    void shouldFindAll() {
        //given -
        SizeModel sizeModel1 = new SizeModel(1, "S", null);
        SizeModel sizeModel2 = new SizeModel(2, "S", null);
        SizeModel sizeModel3 = new SizeModel(3, "S", null);
        List<SizeModel>sizeModels = new ArrayList<>(Arrays.asList(sizeModel1, sizeModel2, sizeModel3));
        given(sizeRepository.findAll()).willReturn(sizeModels);

        //when -
        List<SizeModel> result = underTest.findAll();

        //then -
        verify(sizeRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }

    @Test
    void shouldUpdate() {
        //given -
        SizeModel sizeModel = new SizeModel(1, "S", null);
        given(sizeRepository.save(sizeModel)).willReturn(sizeModel);

        //when -
        SizeModel result = underTest.update(sizeModel);

        //then -
        verify(sizeRepository, times(1)).save(sizeModel);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDelete() {
        //given -
        long sizeId = 1;

        //when -
        doNothing().when(sizeRepository).deleteById(sizeId);
        underTest.delete(sizeId);

        //then -
        verify(sizeRepository, times(1)).deleteById(sizeId);
    }
}
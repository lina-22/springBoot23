package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.ColourModel;
import com.serverSide.javaSpringBoot.model.RatingModel;
import com.serverSide.javaSpringBoot.model.RatingModel;
import com.serverSide.javaSpringBoot.model.RatingModel;
import com.serverSide.javaSpringBoot.repository.RatingRepository;
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
class RatingServiceImplTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingServiceImpl underTest;

    @Test
    void shouldCreate() {
        //given -
        RatingModel ratingModel = new RatingModel(1,12);
        given(ratingRepository.save(ratingModel)).willReturn(ratingModel);

        //when -
        RatingModel result = underTest.create(ratingModel);

        //then -
        verify(ratingRepository, times(1)).save(ratingModel);
        assertThat(result).isNotNull();
        assertThat(result.getRate()).isEqualTo(12);
    }

    @Test
    void shouldFindById() {
        //given -
        long ratingId = 1;
        RatingModel ratingModel = new RatingModel(1, 12);
        given(ratingRepository.findById(ratingId)).willReturn(Optional.of(ratingModel));

        //when -
        Optional<RatingModel> result = underTest.findById(ratingId);

        //then -
        verify(ratingRepository, times(1)).findById(ratingId);
        assertThat(result.get()).isNotNull();
        assertThat(result.get().getRate()).isEqualTo(12);
    }

    @Test
    void shouldFindAll() {

        //given -
        RatingModel ratingModel1 = new RatingModel(1, 12);
        RatingModel ratingModel2 = new RatingModel(2, 14);
        RatingModel ratingModel3 = new RatingModel(3, 16);
        List<RatingModel> ratingModels = new ArrayList<>(Arrays.asList(ratingModel1, ratingModel2, ratingModel3));
        given(ratingRepository.findAll()).willReturn(ratingModels);

        //when -
        List<RatingModel> result = underTest.findAll();

        //then -
        verify(ratingRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }


    @Test
    void shouldUpdate() {
        //given -
        RatingModel ratingModel = new RatingModel(1, 12);
        given(ratingRepository.saveAndFlush(ratingModel)).willReturn(ratingModel);

        //when -
        RatingModel result = underTest.update(ratingModel);

        //then -
        verify(ratingRepository, times(1)).saveAndFlush(ratingModel);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDelete() {

        //given -
        long ratingId = 1;

        //when -
        doNothing().when(ratingRepository).deleteById(ratingId);
        underTest.delete(ratingId);

        //then -
        verify(ratingRepository, times(1)).deleteById(ratingId);
    }
}
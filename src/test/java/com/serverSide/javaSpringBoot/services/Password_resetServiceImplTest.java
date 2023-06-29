package com.serverSide.javaSpringBoot.services;

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
class Password_resetServiceImplTest {

    @Mock
    private Password_resetRepository password_resetRepository;
    @InjectMocks
    private Password_resetServiceImpl underTest;

    @Test
    void shouldCreate() {
        //given -
        Password_resetModel password_resetModel = new Password_resetModel(1, "S", null);
        given(password_resetRepository.save(password_resetModel)).willReturn(password_resetModel);

        //when -
        Password_resetModel result = underTest.create(password_resetModel);

        //then -
        verify(password_resetRepository, times(1)).save(password_resetModel);
        assertThat(result).isNotNull();
        assertThat(result.getToken()).isEqualTo("S");
    }

    @Test
    void shouldFindById() {
        //given -
        long passwordResetId = 1;
        Password_resetModel password_resetModel = new Password_resetModel(1, "S", null);
        given(password_resetRepository.findById(passwordResetId)).willReturn(Optional.of(password_resetModel));

        //when -
        Optional<Password_resetModel> result = underTest.findById(passwordResetId);

        //then -
        verify(password_resetRepository, times(1)).findById(passwordResetId);
        assertThat(result.get()).isNotNull();
        assertThat(result.get().getToken()).isEqualTo("S");
    }

    @Test
    void shouldFindAll() {

        //given -
        Password_resetModel password_resetModel1 = new Password_resetModel(1, "S", null);
        Password_resetModel password_resetModel2 = new Password_resetModel(2, "S", null);
        Password_resetModel password_resetModel3 = new Password_resetModel(3, "S", null);
        List<Password_resetModel> password_resetModels = new ArrayList<>(Arrays.asList(password_resetModel1, password_resetModel2, password_resetModel3));
        given(password_resetRepository.findAll()).willReturn(password_resetModels);

        //when -
        List<Password_resetModel> result = underTest.findAll();

        //then -
        verify(password_resetRepository, times(1)).findAll();
        assertThat(result).isNotNull();
        assertThat(result).size();
    }

    @Test
    void shouldUpdate() {
        //given -
        Password_resetModel password_resetModel = new Password_resetModel(1, "S", null);
        given(password_resetRepository.save(password_resetModel)).willReturn(password_resetModel);

        //when -
        Password_resetModel result = underTest.update(password_resetModel);

        //then -
        verify(password_resetRepository, times(1)).save(password_resetModel);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldDelete() {

        //given -
        long passwordResetId = 1;

        //when -
        doNothing().when(password_resetRepository).deleteById(passwordResetId);
        underTest.delete(passwordResetId);

        //then -
        verify(password_resetRepository, times(1)).deleteById(passwordResetId);
    }
}
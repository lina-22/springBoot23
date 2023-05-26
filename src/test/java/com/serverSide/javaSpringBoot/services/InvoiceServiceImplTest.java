package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//class InvoiceServiceImplTest {
//
//    @Mock
//    private InvoiceRepository invoiceRepository;
//
//    @InjectMocks InvoiceServiceImpl underTest;
//    @Test
//    void shouldCreate() {
//        //given -
//        InvoiceModel invoiceModel = new InvoiceModel(120,12,"S","S",20,50);
//        given(invoiceRepository.save(invoiceModel)).willReturn(invoiceModel);
//
//        //when -
//        InvoiceModel result = underTest.create(invoiceModel);
//
//        //then -
//        verify(invoiceRepository, times(1)).save(invoiceModel);
//        assertThat(result).isNotNull();
//        assertThat(result.getCreateDate()).isEqualTo("2023-04-10");
//    }


//    @Test
//    void shouldFindById() {
//        //given -
//        long invoiceId = 1;
//        InvoiceModel invoiceModel = new InvoiceModel(1, "S", null);
//        given(invoiceRepository.findById(invoiceId)).willReturn(Optional.of(invoiceModel));
//
//        //when -
//        Optional<InvoiceModel> result = underTest.findById(invoiceId);
//
//        //then -
//        verify(invoiceRepository, times(1)).findById(invoiceId);
//        assertThat(result.get()).isNotNull();
//        assertThat(result.get().getCreateDate()).isEqualTo("S");
//    }

//    @Test
//    void shouldFindAll() {
//
//        //given -
//        InvoiceModel invoiceModel1 = new InvoiceModel(1, "S", null);
//        InvoiceModel invoiceModel2 = new InvoiceModel(2, "S", null);
//        InvoiceModel invoiceModel3 = new InvoiceModel(3, "S", null);
//        List<InvoiceModel> invoiceModels = new ArrayList<>(Arrays.asList(invoiceModel1, invoiceModel2, invoiceModel3));
//        given(invoiceRepository.findAll()).willReturn(invoiceModels);
//
//        //when -
//        List<InvoiceModel> result = underTest.findAll();
//
//        //then -
//        verify(invoiceRepository, times(1)).findAll();
//        assertThat(result).isNotNull();
//        assertThat(result).size();
//    }


//    @Test
//    void shouldUpdate() {
//        //given -
//        InvoiceModel invoiceModel = new InvoiceModel(1, "S", null);
//        given(invoiceRepository.saveAndFlush(invoiceModel)).willReturn(invoiceModel);
//
//        //when -
//        InvoiceModel result = underTest.update(invoiceModel);
//
//        //then -
//        verify(invoiceRepository, times(1)).saveAndFlush(invoiceModel);
//        assertThat(result).isNotNull();
//    }


//    @Test
//    void shouldDelete() {
//
//        //given -
//        long invoiceId = 1;
//
//        //when -
//        doNothing().when(invoiceRepository).deleteById(invoiceId);
//        underTest.delete(invoiceId);
//
//        //then -
//        verify(invoiceRepository, times(1)).deleteById(invoiceId);
//    }
//}
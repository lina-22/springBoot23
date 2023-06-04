package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.services.SupplierService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class SupplierManagerTest {

    @Mock
    private SupplierService supplierService;

    @Mock
    private SupplierManager supplierManager;

    @InjectMocks
    private SupplierManager underTest;

    @Test
    void shouldCreateSupplier(){
        //given


        //when

        //then
    }


    @Test
    void shouldGetAllSupplier() {

        //given


        //when

        //then
    }

    @Test
    void shouldGetSupplierById() {

        //given


        //when

        //then
    }

    @Test
    void shouldUpdateSupplier() {

        //given


        //when

        //then
    }

    @Test
    void shouldDeleteSupplierById() {

        //given


        //when

        //then
    }

    @Test
    void shouldConvertToSupplierModel() {

        //given


        //when

        //then
    }

    @Test
    void shouldConvertToSupplierDto() {

        //given


        //when

        //then
    }
}
package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.ReservationProductForSale;
import com.serverSide.javaSpringBoot.model.ReservationProductForSaleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationProductForSaleRepository extends JpaRepository<ReservationProductForSale, ReservationProductForSaleId> { }

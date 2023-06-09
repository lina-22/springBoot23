package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.ReservationAvailableProduct;
import com.serverSide.javaSpringBoot.model.ReservationAvailableProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationAvailableProductRepository extends JpaRepository<ReservationAvailableProduct, ReservationAvailableProductId> { }

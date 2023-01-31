package com.clickAndcollect.javaSpringBoot.repository;

import com.clickAndcollect.javaSpringBoot.model.ProductModel;
import com.clickAndcollect.javaSpringBoot.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {
}

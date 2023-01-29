package com.clickAndcollect.javaSpringBoot.repository;


import com.clickAndcollect.javaSpringBoot.model.AvailableProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableProductRepository extends JpaRepository<AvailableProductModel, Long> {
}

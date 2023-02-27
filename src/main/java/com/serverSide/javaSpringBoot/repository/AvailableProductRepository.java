package com.serverSide.javaSpringBoot.repository;


import com.serverSide.javaSpringBoot.model.AvailableProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableProductRepository extends JpaRepository<AvailableProductModel, Long> {
}

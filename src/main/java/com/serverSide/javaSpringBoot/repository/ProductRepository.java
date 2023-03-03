package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> { }

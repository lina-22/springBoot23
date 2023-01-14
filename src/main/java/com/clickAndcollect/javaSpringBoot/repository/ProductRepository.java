package com.clickAndcollect.javaSpringBoot.repository;

import com.clickAndcollect.javaSpringBoot.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}

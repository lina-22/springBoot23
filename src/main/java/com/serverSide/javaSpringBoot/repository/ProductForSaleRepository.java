package com.serverSide.javaSpringBoot.repository;


import com.serverSide.javaSpringBoot.model.ProductForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductForSaleRepository extends JpaRepository<ProductForSale, Long> {
}

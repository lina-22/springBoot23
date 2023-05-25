package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
}

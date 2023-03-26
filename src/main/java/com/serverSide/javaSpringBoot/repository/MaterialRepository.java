package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {
}

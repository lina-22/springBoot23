package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository  extends JpaRepository<SizeModel, Long> {
}


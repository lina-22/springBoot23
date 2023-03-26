package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.Password_resetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Password_resetRepository extends JpaRepository<Password_resetModel, Long> {
}

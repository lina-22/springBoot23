package com.clickAndcollect.javaSpringBoot.repository;

import com.clickAndcollect.javaSpringBoot.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

}

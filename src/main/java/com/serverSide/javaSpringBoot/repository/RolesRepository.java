package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
    RolesModel findByName(String name);

}
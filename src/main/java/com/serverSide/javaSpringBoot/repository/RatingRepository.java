package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {
}

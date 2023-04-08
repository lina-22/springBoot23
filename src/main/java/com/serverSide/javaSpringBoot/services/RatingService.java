package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.RatingModel;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    RatingModel create(RatingModel ratingModel);
    Optional<RatingModel> findById(long rating_id);

    List<RatingModel> findAll();

    RatingModel update(RatingModel ratingModel);

    void delete(long rating_id);
}

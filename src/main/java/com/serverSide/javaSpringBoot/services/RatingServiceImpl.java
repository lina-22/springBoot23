package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.RatingModel;
import com.serverSide.javaSpringBoot.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class RatingServiceImpl implements RatingService{


    RatingRepository ratingRepository;

    @Override
    public RatingModel create(RatingModel ratingModel) {
        return ratingRepository.save(ratingModel);
    }

    @Override
    public Optional<RatingModel> findById(long rating_id) {
        return ratingRepository.findById(rating_id);
    }

    @Override
    public List<RatingModel> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public RatingModel update(RatingModel ratingModel) {
        return ratingRepository.saveAndFlush(ratingModel);
    }

    @Override
    public void delete(long rating_id) {
        ratingRepository.deleteById(rating_id);

    }
}

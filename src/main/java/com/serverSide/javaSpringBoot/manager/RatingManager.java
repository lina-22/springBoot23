package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingManager {

    private RatingService ratingService;


}

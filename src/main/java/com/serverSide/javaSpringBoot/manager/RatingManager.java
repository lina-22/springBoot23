package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.RatingDto;
import com.serverSide.javaSpringBoot.model.ProductModel;
import com.serverSide.javaSpringBoot.model.RatingModel;
import com.serverSide.javaSpringBoot.services.ProductService;
import com.serverSide.javaSpringBoot.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RatingManager {

    private RatingService ratingService;
    private ProductService productService;

    public String createRating(RatingDto ratingDto){
        Optional<ProductModel> productModel = productService.findById(ratingDto.getProductId());

        RatingModel ratingToAdd = toRatingModel(ratingDto);
        RatingModel addedRatingModel = ratingService.create(ratingToAdd);

        Set<RatingModel> ratingModelSet = new HashSet<>();
        ratingModelSet.add(addedRatingModel);

        if(productModel.isPresent()){
            productModel.get().setRatingModels(ratingModelSet);
        }
        ProductModel updatedProductModel=productService.update(productModel.get());
        if(updatedProductModel !=null){
            return "Rating added successfully";
        }
        return "Something went wrong";
    }

    public List<RatingDto> getAllRating() {
        List<RatingDto>ratingDtoList = new ArrayList<>();
        List<RatingModel> ratingModelList = ratingService.findAll();
        ratingModelList.forEach(data-> {
            ratingDtoList.add(toRatingDto(data));
        });
        return ratingDtoList;

    }

    public RatingDto getRatingById(long ratingId){
        return toRatingDto(ratingService.findById(ratingId).get());
    }


    public RatingDto updateRating(RatingDto ratingDto){
        Optional<RatingModel> ratingModel =  ratingService.findById(ratingDto.getRatingId());
        if (ratingModel.isPresent()){
            ratingModel.get().setRate(ratingDto.getRate());
            RatingModel updatedRatingModel =  ratingService.update(ratingModel.get());
            return toRatingDto(updatedRatingModel);
        }
        return new RatingDto();

    }

    public void deleteRatingById(long rating_id){

        ratingService.delete(rating_id);
    }
    // ******************* the dto to model data transfer****************

    public RatingModel toRatingModel(RatingDto ratingDto){

        RatingModel ratingModel= new RatingModel();
        ratingModel.setRate(ratingDto.getRate());
        return ratingModel;
    }



    // ******************* the model to dto data transfer****************

    public RatingDto toRatingDto(RatingModel ratingModel){
           RatingDto ratingDto = new RatingDto();
           ratingDto.setRatingId(ratingModel.getRatingId());
           ratingDto.setRate(ratingModel.getRate());
//           ratingDto.setProductId(ratingModel.getUser);
           return ratingDto;
    }

}

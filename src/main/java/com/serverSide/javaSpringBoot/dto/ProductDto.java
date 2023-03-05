package com.serverSide.javaSpringBoot.dto;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private  String name;
    private boolean is_featured = false;
    private Double price = 0.0;
    private Double discount = 0.0;
    private String image;
    private String description;
    private String importCountry;
    private Set<CategoryModel> mCategories = new HashSet<>();
    private List<Long> categoryIds;


}

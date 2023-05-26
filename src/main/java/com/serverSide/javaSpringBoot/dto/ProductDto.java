package com.serverSide.javaSpringBoot.dto;

import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long productId;
    private  String name;
    private boolean is_featured = false;
    private Double price = 0.0;
    private Double discount = 0.0;
    private byte[] image;
    private String description;
    private String importCountry;
    private Set<AvailableProductDtoRes> availableProductDtoRes;
    private Set<AvailableProductDtoReq> availableProductDtoReq;
    private long supplierId;



}

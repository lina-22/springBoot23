package com.serverSide.javaSpringBoot.dto;

import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long productId;
    private  String name;
    private Double price = 0.0;
    private Double discount = 0.0;
    private byte[] image;
    private String description;
    private String importCountry;
    private List<ProductForSaleResDto> productForSaleResDtos;
    private List<ProductForSaleReqDto> productForSaleReqDto;
    private long supplierId;



}

package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductForSaleResDto {

    private long id;
    private int qty;
    private String skuReference;
    private String category;
    private String colour;
    private String material;
    private String size;

}

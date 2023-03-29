package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableProductDto {

    private long apId;
    private int apQuantity;
    private String skuReference;
    private long categoryId;
    private long colourId;
    private long materialId;
    private long sizeId;


}

package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private long categoryId;
    private String categoryValue;

    //private Set<ProductModel> mProducts = new HashSet<>();
    //private List<Long> productIds;
}

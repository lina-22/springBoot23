package com.serverSide.javaSpringBoot.dto;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    long category_id;
    String category_value;

    //private Set<ProductModel> mProducts = new HashSet<>();
    //private List<Long> productIds;
}

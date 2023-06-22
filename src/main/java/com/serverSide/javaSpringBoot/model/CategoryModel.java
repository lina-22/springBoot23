package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class CategoryModel {

    @Id
    @Column(name ="category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "category_value", nullable = false)
    private String categoryValue;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryModel", fetch = FetchType.LAZY)
    private Set<ProductForSale> productForSale = new HashSet<>();

}

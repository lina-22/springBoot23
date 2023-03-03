package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class ProductModel {

   //mamy to many relation indication start from here

    //*************All column name start************//
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO) // id auto increment
    private Long id;

    @Column(name="name", nullable = false)
    private  String name;

    @Column(name= "is_featured", nullable = false)
    private boolean is_featured = false;

    @Column(name= "price", nullable = false , columnDefinition = "Decimal(10,2) default '0.00'")// here datatype and default value included in the same line
    private Double price = 0.0;

    @Column(name="discount", nullable = false,  columnDefinition = "Decimal(10,2) default '0.00'")
    private Double discount = 0.0;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "importCountry", nullable = true)
    private String importCountry;

    @ManyToMany(fetch = FetchType.LAZY, cascade =  { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    @JoinTable(
            name = "category_product",
            joinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "category_id", referencedColumnName = "id")}
    )
    @JsonIgnore
    private Set<CategoryModel> mCategories = new HashSet<>();


}

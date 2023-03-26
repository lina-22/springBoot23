package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter // from  dependency lombok
@Setter // from  dependency lombok
@NoArgsConstructor // from  dependency lombok
@AllArgsConstructor // from  dependency lombok
@Table(name = "products")
public class ProductModel {

    @Id // id will autogenerate at the Db by the @Id
    @Column(name ="product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto increment
    private Long product_id;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_prd_id", referencedColumnName = "product_id")
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();


}

package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AvailableProduct")
@IdClass(AvailableProductPKId.class)
public class AvailableProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private long product_id;

    @Column(name = "colour", nullable = true)
    private String colour;

    @Column(name="quantity", nullable = true)
    private String quantity;

    @Column(name="size", nullable = true)
    private String size;


    /*@ManyToOne
    @JoinColumn(name = "pa_fk", referencedColumnName = "id")
    private ProductModel productModel;*/


}

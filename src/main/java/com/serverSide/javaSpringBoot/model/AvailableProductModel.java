package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AvailableProduct")
@IdClass(AvailableProductPKId.class) // id object ?
public class AvailableProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ap_id;

    @Column(name="ap_quantity", nullable = true)
    private String ap_quantity;

    @Column(name="sku_reference", nullable = true)
    private String sku_reference;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel productModel;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryModel categoryModel;

    @JsonIgnore
    @ManyToMany(mappedBy = "mAvailableProduct")
    private Set<ReservationModel>mReservations = new HashSet<>();

}

package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="AvailableProduct")
public class AvailableProductModel {

    @Id
    @Column(name="ap_id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long apId;

    @Column(name="ap_quantity", nullable = true)
    private int apQuantity;

    @Column(name="sku_reference", nullable = true)
    private String skuReference;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryModel categoryModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "size_id", referencedColumnName = "size_id")
    private SizeModel sizeModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "colour_id", referencedColumnName = "colour_id")
    private ColourModel colourModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private MaterialModel materialModel;

    @JsonIgnore
    @OneToMany(mappedBy = "availableProductModel", cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReservationAvailableProduct> reservationAvailableProducts = new ArrayList<>();
    /*@JsonIgnore
    @ManyToMany(mappedBy = "mAvailableProduct")
    private Set<ReservationModel>mReservations = new HashSet<>();*/


    /*@ManyToOne(targetEntity = RolesModel.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")*/

    //@JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_prd_id", referencedColumnName = "product_id")
    private ProductModel productModel;


}

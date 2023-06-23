package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product_for_sale")
public class ProductForSale {

    @Id
    @Column(name="id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="quantity", nullable = true)
    private int quantity;

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
    @OneToMany(mappedBy = "productForSale", cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReservationProductForSale> reservationProductForSales = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_prd_id", referencedColumnName = "product_id")
    private ProductModel productModel;


}

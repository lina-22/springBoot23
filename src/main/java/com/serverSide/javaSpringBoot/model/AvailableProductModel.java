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
public class AvailableProductModel {

    @Id
    @Column(name="ap_id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ap_id;

    @Column(name="ap_quantity", nullable = true)
    private String ap_quantity;

    @Column(name="sku_reference", nullable = true)
    private String sku_reference;


    /*@ManyToOne(targetEntity = RolesModel.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")*/
 /*   @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Set<ProductModel> productModel = new HashSet<>();
*/
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryModel categoryModel;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "size_id")
    private SizeModel sizeModel;

    @ManyToOne
    @JoinColumn(name = "colour_id", referencedColumnName = "colour_id")
    private ColourModel colourModel;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    private MaterialModel materialModel;

    @JsonIgnore
    @ManyToMany(mappedBy = "mAvailableProduct")
    private Set<ReservationModel>mReservations = new HashSet<>();

}

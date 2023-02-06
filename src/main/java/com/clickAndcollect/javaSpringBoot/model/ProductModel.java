package com.clickAndcollect.javaSpringBoot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductModel {

    @ManyToMany(mappedBy = "productModelSet")
    Set<CategoryModel> categoryModelSet;
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private  String name;

    @Column(name= "is_featured", nullable = false, columnDefinition ="false")
    private boolean is_featured;

    @Column(name= "price", nullable = false, columnDefinition ="0.0")
    private Double price;

    @Column(name="discount", nullable = false, columnDefinition ="0.0")
    private Double discount;

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "description", nullable = true)
    private String description;


    @Column(name = "importCountry", nullable = true)
    private String importCountry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImportCountry() {
        return importCountry;
    }

    public void setImportCountry(String importCountry) {
        this.importCountry = importCountry;
    }



}

//id/name/is_featured/price/discount/image/description

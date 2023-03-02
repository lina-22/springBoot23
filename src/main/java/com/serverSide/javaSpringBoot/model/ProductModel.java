package com.serverSide.javaSpringBoot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductModel {


    public void addModel(Long id, String name, boolean is_featured, Double price, Double discount, String image, String description, String importCountry) {
        this.id = id;
        this.name = name;
        this.is_featured = is_featured;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.description = description;
        this.importCountry = importCountry;
    }


   //mamy to many relation indication start from here
    @ManyToMany(fetch = FetchType.LAZY, cascade =  { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
    @JoinTable(
            name = "category_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )

    //mamy to many relation indication end here

    //*************************//
    private final Set<CategoryModel> mCategories = new HashSet<>();

    public ProductModel() {

    }

    public void addCategory(CategoryModel category) {
        this.mCategories.add(category);
    }

    public Set<CategoryModel> getCategories() {
        return mCategories;
    }

    //*************************??//

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

       //*************All column name end************//

    //*************Getter and setter start************//
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
    } // is_featured getId is boolean so dont have get featured

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

         //*************Getter and setter end************//
//id/name/is_featured/price/discount/image/description

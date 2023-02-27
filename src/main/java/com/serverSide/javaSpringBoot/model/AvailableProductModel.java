package com.serverSide.javaSpringBoot.model;

import javax.persistence.*;

@Entity
@Table(name="AvailableProduct")
public class AvailableProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idProduct; idProduct should be primary and secondary

    @Column(name = "colour", nullable = true)
    private String colour;

    @Column(name="quantity", nullable = true)
    private String quantity;

    @Column(name="size", nullable = true)
    private String size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}

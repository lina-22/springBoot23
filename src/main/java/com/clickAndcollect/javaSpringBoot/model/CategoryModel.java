package com.clickAndcollect.javaSpringBoot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryModel {

    //@Column(name = "id", nullable = false)
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<ProductModel> productModelSet;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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

}


//persistence = জেদ/Persistance/détermination/অধ্যবসায়/save
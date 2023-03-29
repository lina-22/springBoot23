package com.serverSide.javaSpringBoot.model;

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
@Table(name = "categories")
public class CategoryModel {

    @Id
    @Column(name ="category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "category_value", nullable = false)
    private String categoryValue;

    @OneToMany(mappedBy = "categoryModel", fetch = FetchType.LAZY)
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryId=" + categoryId +
                ", categoryValue='" + categoryValue + '\'' +
                ", availableProductModel=" + availableProductModel +
                '}';
    }

}

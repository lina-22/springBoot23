package com.serverSide.javaSpringBoot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class MaterialModel {
    @Id
    @Column(name ="material_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long material_id;

    @Column(name = "material_value", nullable = false)
    private String material_value;

    @OneToMany(mappedBy = "materialModel", fetch = FetchType.LAZY)
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();
}

package com.serverSide.javaSpringBoot.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ColourModel {

    @Id
    @Column(name ="colour_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long colour_id;

    @Column(name = "colour_value", nullable = false)
    private String colour_value;

    @OneToMany(mappedBy = "colourModel", fetch = FetchType.LAZY)
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();
}

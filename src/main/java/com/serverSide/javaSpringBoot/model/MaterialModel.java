package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materials")
public class MaterialModel {
    @Id
    @Column(name ="material_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long materialId;

    @Column(name = "material_value", nullable = false)
    private String materialValue;

    @OneToMany(mappedBy = "materialModel", fetch = FetchType.LAZY)
    private Set<ProductForSale> productForSale = new HashSet<>();
}

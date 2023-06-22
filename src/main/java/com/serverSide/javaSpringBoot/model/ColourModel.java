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
@Table(name = "colours")
public class ColourModel {

    @Id
    @Column(name ="colour_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long colourId;

    @Column(name = "colour_value", nullable = false)
    private String colourValue;

    @OneToMany(mappedBy = "colourModel", fetch = FetchType.LAZY)
    private Set<ProductForSale> productForSale = new HashSet<>();

}

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
@Table(name = "sizes")
public class SizeModel {

    @Id
    @Column(name ="size_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long size_id;

    @Column(name = "size_value", nullable = false)
    private String size_value;

    @OneToMany(mappedBy = "sizeModel", fetch = FetchType.LAZY)
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();
}

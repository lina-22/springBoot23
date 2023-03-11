package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class ReservationModel {
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @Column(name ="idUser", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idUser;


    @Column(name="reference", nullable = false)
    private String reference;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="expireDate", nullable = false)
    private Date expireDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "product_lines",
            joinColumns = {@JoinColumn(name = "reservation_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "avl_product_id",referencedColumnName = "id"),
                    @JoinColumn(name = "product_id",referencedColumnName = "pa_fk")}
    )
   @JsonIgnore
    private Set<AvailableProductModel> mAvailableProduct = new HashSet<>();
}

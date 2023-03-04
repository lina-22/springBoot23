package com.serverSide.javaSpringBoot.model;

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

    @ManyToMany(mappedBy = "mReservation")
    private Set<AvailableProductModel> mAvailableProducts = new HashSet<>();
}

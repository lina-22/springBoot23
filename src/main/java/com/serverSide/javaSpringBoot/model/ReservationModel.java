package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class ReservationModel {

    @Id
    @Column(name ="reservation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;

    @Column(name="reference", nullable = false)
    private String reference;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="expire_date", nullable = false)
    private Date expireDate;

    @OneToMany(mappedBy = "reservationModel", cascade = CascadeType.ALL)
    private List<ReservationAvailableProduct> reservationAvailableProducts = new ArrayList<>();

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "product_lines",
            joinColumns = {@JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")},
            inverseJoinColumns = {@JoinColumn(name = "ap_id",referencedColumnName = "ap_id")}
    )
   @JsonIgnore
    private Set<AvailableProductModel> mAvailableProduct = new HashSet<>();*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "fk_usr_id", referencedColumnName = "users_id")
    private UserModel userModel;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentModel paymentModel;
}

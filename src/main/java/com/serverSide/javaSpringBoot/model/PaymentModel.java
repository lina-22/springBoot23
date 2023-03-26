package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class PaymentModel {

    @Id
    @Column(name ="payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "date_payment", nullable = false)
    private Date date_payment;

    @Column(name = "details", nullable = false)
    private String details;


    @OneToMany(mappedBy = "paymentModel", fetch = FetchType.LAZY)
    private Set<ReservationModel> reservationModel = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private UsersModel usersModel;
}

package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentModel {
    @Id
    @Column(name ="payment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "date_payment")
    @CreationTimestamp
    private Date datePayment;

    @Column(name = "details", nullable = false)
    private String details;

    @JsonIgnore
    @OneToMany(mappedBy = "paymentModel", fetch = FetchType.LAZY)
    private Set<ReservationModel> reservationModel = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private UserModel userModel;
}

package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Getter
@Setter
public class UserModel {

    @Id
    @Column(name ="users_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name="first_name", nullable = false)
    private  String firstName;

    @Column(name="last_name", nullable = false)
    private  String lastName;

    @Column(name="email", nullable = false)
    private  String email;

    @Column(name="password", nullable = false)
    private  String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    )
    @JsonIgnore
    private List<RolesModel> rolesModelSet;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usr_id", referencedColumnName = "users_id")
    private Set<ReservationModel> reservationModel;

/*
   //@OneToMany(mappedBy = "userModel")
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usr_id", referencedColumnName = "users_id")
    private Set<PaymentModel> paymentModel;

    //@OneToMany(mappedBy = "userModel")
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usr_id", referencedColumnName = "users_id")
    private Set<Password_resetModel> password_resetModelModel;
*/



}

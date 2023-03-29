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
@Table(name = "users")
public class UsersModel {

    @Id
    @Column(name ="users_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usersId;

    @Column(name="first_name", nullable = false)
    private  String firstName;

    @Column(name="last_name", nullable = false)
    private  String lastName;

    @Column(name="email", nullable = false)
    private  String email;

    @Column(name="password", nullable = false)
    private  String password;

    @OneToMany(mappedBy = "usersModel")
    private Set<ReservationModel> reservationModel;

    @OneToMany(mappedBy = "usersModel")
    private Set<PaymentModel> paymentModel;

    @OneToMany(mappedBy = "usersModel")
    private Set<Password_resetModel> password_resetModelModel;

    @ManyToOne(targetEntity = RolesModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Set<RolesModel> rolesModel = new HashSet<>();

}

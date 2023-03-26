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
@Table(name = "password_reset")
public class Password_reset {
    @Id
    @Column(name ="password_reset_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long password_reset_id;

    @Column(name = "token", nullable = false)
    private BigDecimal token;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private UsersModel usersModel;
}

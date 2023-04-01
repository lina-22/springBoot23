package com.serverSide.javaSpringBoot.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "password_reset")
public class Password_resetModel {
    @Id
    @Column(name ="password_reset_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passwordResetId;

    @Column(name = "token", nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private UserModel userModel;
}

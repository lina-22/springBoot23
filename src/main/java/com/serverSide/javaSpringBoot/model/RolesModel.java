package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RolesModel {

    @Id
    @Column(name ="role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name="name", nullable = false)
    private  String name;

    @OneToMany(mappedBy = "rolesModel")
    private Set<UsersModel> userModel;
}

package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@Data
public class RolesModel {

    @Id
    @Column(name ="role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name="name", nullable = false)
    private  String name;

    @JsonIgnore
    @OneToMany(mappedBy = "rolesModel")
    private Set<UserModel> userModel;

}

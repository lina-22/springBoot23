package com.serverSide.javaSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@Getter
@Setter
public class RolesModel {

    @Id
    @Column(name ="role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    @Column(name="name", nullable = false)
    private  String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "rolesModelSet",fetch = FetchType.EAGER)
    private List<UserModel> userModelSet;
}


/*    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id",referencedColumnName = "users_id")}
    )
   @JsonIgnore
    private Set<UserModel> userModel = new HashSet<>();
*/
package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private long usersId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

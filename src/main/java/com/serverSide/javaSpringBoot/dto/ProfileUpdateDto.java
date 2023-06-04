package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDto {

    private long userId;
    private String firstName;
    private String lastName;
    private String passwordSuccessfullyUpdated;
    private String email;
    private String role;
}

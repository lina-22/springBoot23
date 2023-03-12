package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.manager.ReservationManager;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersManager usersManager;
    @PostMapping
    public UsersDto createUsers(@RequestBody UsersDto usersDto){
        return usersManager.createUsers(usersDto);
    }
}

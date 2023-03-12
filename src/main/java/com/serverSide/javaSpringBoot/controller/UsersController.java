package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersManager usersManager;
    @PostMapping
    public UsersDto createUsers(@RequestBody UsersDto usersDto){

        return usersManager.createUsers(usersDto);
    }

    @GetMapping
    public List<UsersDto> getAllUsers(){
        return usersManager.getAllUsers();
    }
}

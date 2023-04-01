package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final UsersManager usersManager;

    @PostMapping
    public UserDto createUsers(@RequestBody UserDto userDto){
        return usersManager.createUser(userDto);
    }

}

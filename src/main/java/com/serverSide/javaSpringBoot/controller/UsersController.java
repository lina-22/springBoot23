package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersManager usersManager;

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDto> register(@RequestBody UserDto userDTO){
        return ResponseEntity.ok(usersManager.registerUser(userDTO));
    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return usersManager.getAllUsers();
    }

}

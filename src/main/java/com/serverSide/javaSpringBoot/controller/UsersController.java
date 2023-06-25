package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping(path = "/{email}")
    public UserDto getUserById(@PathVariable String email){
        return usersManager.getUsersByEmail(email);
    }

    @PutMapping
    public BaseResponseDto updateUser(@RequestBody UserDto userDTO){
        return usersManager.updateUsers(userDTO);
    }

    @DeleteMapping(path = "/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email){
        try{
            usersManager.getUsersByEmail(email);
            usersManager.deleteUserById(usersManager.getUsersByEmail(email).getUserId());
            return new ResponseEntity<>("User with email +" + email + "has benn deleted sucessfuly .", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Something went wrong ", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}

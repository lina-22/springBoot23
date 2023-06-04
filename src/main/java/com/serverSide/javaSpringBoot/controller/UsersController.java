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

    @GetMapping(path = "/{usersid}")
    public UserDto getUserById(@PathVariable long usersid){
        return usersManager.getUsersById(usersid);
    }

    @PutMapping
    public BaseResponseDto updateUser(@RequestBody UserDto userDTO){
        return usersManager.updateUsers(userDTO);
    }

    @DeleteMapping(path = "/{usersid}")
    public ResponseEntity<String> deleteUserById(@PathVariable long usersid){
        try{
            usersManager.deleteUserById(usersid);
            return new ResponseEntity<>("User with id +" + usersid + "has benn deleted sucessfuly .", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Something went wrong ", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}

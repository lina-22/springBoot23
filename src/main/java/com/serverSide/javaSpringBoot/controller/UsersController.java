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

    @GetMapping(path = "/{users_id}")
    public UserDto getUserById(@PathVariable long users_id){
        return usersManager.getUsersById(users_id);
    }

    @PutMapping
    public UserDto updateUserById(@RequestBody UserDto userDTO){
        return usersManager.updateUsers(userDTO);
    }

    @DeleteMapping(path = "/{users_id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long users_id){
        try{
            usersManager.deleteUserById(users_id);
            return new ResponseEntity<>("User with id +" + users_id + "has benn deleted sucessfuly .", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("User with" + users_id + "not found", HttpStatus.NOT_FOUND);
        }
    }
}

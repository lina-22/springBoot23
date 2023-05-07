package com.serverSide.javaSpringBoot.controller.testSecurity;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.manager.UsersManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final UsersManager usersManager;

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDto>register(@RequestBody UserDto userDTO){
        return ResponseEntity.ok(usersManager.registerUser(userDTO));
    }
}

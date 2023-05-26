package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.dto.Password_resetDto;
import com.serverSide.javaSpringBoot.manager.PasswordResetManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passReset")
@AllArgsConstructor
public class PasswordResetController {
    private final PasswordResetManager passwordResetManager;
    @PostMapping
    public Password_resetDto createPasswordReset(@RequestBody Password_resetDto password_resetDto){
        return passwordResetManager.createPassword_reset(password_resetDto);
    }



}

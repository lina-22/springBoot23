package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.dto.Password_resetDto;
import com.serverSide.javaSpringBoot.manager.PasswordResetManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passReset")
@AllArgsConstructor
public class PasswordResetController {
    private final PasswordResetManager passwordResetManager;
    @PostMapping
    public Password_resetDto createPasswordReset(@RequestBody Password_resetDto password_resetDto){
        return passwordResetManager.createPassword_reset(password_resetDto);
    }

    @GetMapping
    public List<Password_resetDto> getAllPasswordReset(){

        return passwordResetManager.getAllPassword_reset();
    }

    @GetMapping(path = "/{password_reset_id}")
    public Password_resetDto getPasswordResetById(@PathVariable long password_reset_id){
        return passwordResetManager.getPassword_resetById(password_reset_id);
    }

    @PutMapping
    public Password_resetDto updatePasswordResetById(@RequestBody Password_resetDto password_resetDto){
        return passwordResetManager.updatePassword_reset(password_resetDto);
    }

    @DeleteMapping(path = "/{password_reset_id}")
    public ResponseEntity<String> deletePasswordResetById(@PathVariable long password_reset_id){
        try{
            passwordResetManager.deletePassword_resetById(password_reset_id);
            return new ResponseEntity<>("Password_reset with id +" + password_reset_id + "has benn deleted sucessfuly .", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Password_reset with" + password_reset_id + "not found", HttpStatus.NOT_FOUND);
        }
    }
}

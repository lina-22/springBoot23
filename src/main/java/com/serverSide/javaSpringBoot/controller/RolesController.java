package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.manager.RolesManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {

    private final RolesManager rolesManager;
    @PostMapping
    public RolesDto createRole(@RequestBody RolesDto rolesDto){

        return rolesManager.createRoles(rolesDto);
    }
}

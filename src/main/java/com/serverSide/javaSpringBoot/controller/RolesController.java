package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.manager.RolesManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {

    private final RolesManager rolesManager;
    @PostMapping
    public RolesDto createRoles(@RequestBody RolesDto rolesDto){

        return rolesManager.createRoles(rolesDto);
    }

    @GetMapping
    public List<RolesDto> getAllRoles(){
        return rolesManager.getAllRoles();
    }

    @GetMapping(path="/{role_id}")
    public RolesDto getRolesById(@PathVariable long role_id){
        return rolesManager.getRoleById(role_id);
    }

    @PutMapping
    public RolesDto updateRolesById(@RequestBody RolesDto rolesDto){

        return  rolesManager.updateRoles(rolesDto);
    }

    @DeleteMapping(path = "/{role_id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable long role_id){
        try{
            rolesManager.deleteRoleById(role_id);
            return new ResponseEntity<>("Roles with id + " + role_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            return new ResponseEntity<>("Roles with " + role_id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}

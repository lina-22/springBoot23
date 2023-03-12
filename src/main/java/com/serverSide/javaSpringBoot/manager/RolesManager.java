package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import com.serverSide.javaSpringBoot.services.UsersService;

public class RolesManager {

    private RolesService rolesService;
    public RolesDto createRoles(RolesDto rolesDto){
        RolesModel rolesToAdd = toRolesModel(rolesDto);
        RolesModel addedRoles = rolesService.create(rolesToAdd);

        return toRolesDto(addedRoles);
    }
    // ******************* the dto to model data transfer****************
    public RolesModel toRolesModel(RolesDto rolesDto){
        RolesModel rolesModel = new RolesModel();
        rolesModel.setName(rolesDto.getName());

        return rolesModel;
    }

    public RolesDto toRolesDto(RolesModel rolesModel){
        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(rolesModel.getId());
        rolesDto.setName(rolesModel.getName());

        return  rolesDto;
    }


    // *******************the dto to model data transfer****************
}
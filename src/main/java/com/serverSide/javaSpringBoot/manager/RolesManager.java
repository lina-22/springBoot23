package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UsersModel;

public class RolesManager {

    // ******************* the dto to model data transfer****************
    public RolesModel toRolesModel(RolesDto rolesDto){
        RolesModel rolesModel = new RolesModel();
        rolesModel.setName(rolesDto.getName());

        return rolesModel;
    }

    public RolesDto toUsersDto(RolesModel rolesModel){
        RolesDto rolesDto = new RolesDto();
        rolesDto.setId(rolesModel.getId());
        rolesDto.setName(rolesModel.getName());

        return  rolesDto;
    }


    // *******************the dto to model data transfer****************
}

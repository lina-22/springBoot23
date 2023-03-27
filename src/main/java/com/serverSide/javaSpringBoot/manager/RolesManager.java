package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RolesManager {

   private RolesService rolesService;
    public RolesDto createRoles(RolesDto rolesDto){
        RolesModel rolesToAdd = toRolesModel(rolesDto);
        RolesModel addedRoles = rolesService.create(rolesToAdd);
        return toRolesDto(addedRoles);
    }

    public List<RolesDto> getAllRoles() {
        List<RolesDto>rolesDtoList = new ArrayList<>();
        List<RolesModel> rolesModelList = rolesService.findAll();
        rolesModelList.forEach(data-> {
            rolesDtoList.add(toRolesDto(data));
        });
        return rolesDtoList;

    }



    // ******************* the dto to model data transfer****************
    public RolesModel toRolesModel(RolesDto rolesDto){
        RolesModel rolesModel = new RolesModel();
        rolesModel.setName(rolesDto.getName());
        return rolesModel;
    }

  public RolesDto toRolesDto(RolesModel rolesModel){
        RolesDto rolesDto = new RolesDto();
        rolesDto.setRole_id(rolesModel.getRole_id());
        rolesDto.setName(rolesModel.getName());

        return  rolesDto;
    }


    // *******************end the dto to model data transfer****************
}




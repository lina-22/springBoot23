package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.RolesDto;
import com.serverSide.javaSpringBoot.model.MaterialModel;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public RolesDto getRoleById(long roles_id){

        return toRolesDto(rolesService.findById(roles_id).get());
    }


    public RolesDto updateRoles(RolesDto rolesDto){
        Optional<RolesModel> rolesModel =  rolesService.findById(rolesDto.getRole_id());
        if (rolesModel.isPresent()){
            rolesModel.get().setName(rolesDto.getName());
            RolesModel updatedRolesModel =  rolesService.update(rolesModel.get());
            return toRolesDto(updatedRolesModel);
        }
        return new RolesDto();

    }

    public void deleteRoleById(long role_id){

        rolesService.delete(role_id);
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




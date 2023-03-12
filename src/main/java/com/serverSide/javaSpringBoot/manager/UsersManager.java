package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.services.ReservationService;
import com.serverSide.javaSpringBoot.services.UsersService;

public class UsersManager {
    private UsersService usersService;
    public UsersDto createUsers(UsersDto usersDto){
        UsersModel usersToAdd = toUsersModel(usersDto);
        UsersModel addedUsers = usersService.create(usersToAdd);

        return toUsersDto(addedUsers);
    }

    // ******************* the dto to model data transfer****************
    public UsersModel toUsersModel(UsersDto usersDto){
        UsersModel usersModel = new UsersModel();
        usersModel.setFirst_name(usersDto.getFirst_name());
        usersModel.setLast_name(usersDto.getLast_name());
        usersModel.setEmail(usersDto.getEmail());
        usersModel.setPassword(usersDto.getPassword());

        return usersModel;
    }

    public UsersDto toUsersDto(UsersModel usersModel){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(usersModel.getId());
        usersDto.setFirst_name(usersModel.getFirst_name());
        usersDto.setLast_name(usersModel.getLast_name());
        usersDto.setEmail(usersModel.getEmail());
        usersDto.setPassword(usersModel.getPassword());

        return  usersDto;
    }


    // *******************the dto to model data transfer****************
}

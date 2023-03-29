package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersManager {
    private UsersService usersService;
   public UsersDto createUsers(UsersDto usersDto){
        UsersModel usersToAdd = toUsersModel(usersDto);
        UsersModel addedUsers = usersService.create(usersToAdd);
        return toUsersDto(addedUsers);

    }


    public List<UsersDto> getAllUsers() {
        List<UsersDto>usersDtoList = new ArrayList<>();
        List<UsersModel> usersModelList = usersService.findAll();
        usersModelList.forEach(data-> {
            usersDtoList.add(toUsersDto(data));
        });
        return usersDtoList;
    }

    public UsersDto getUsersById(long users_id){

        return toUsersDto(usersService.findById(users_id).get());
    }

    public UsersDto updateUsers(UsersDto usersDto){
        Optional<UsersModel> usersModel =  usersService.findById(usersDto.getUsersId());
        if (usersModel.isPresent()){
            usersModel.get().setFirstName(usersDto.getFirstName());
            usersModel.get().setLastName(usersDto.getLastName());
            usersModel.get().setEmail(usersDto.getEmail());
            usersModel.get().setPassword(usersDto.getPassword());
            UsersModel updatedUsersModel =  usersService.update(usersModel.get());
            return toUsersDto(updatedUsersModel);
        }
        return new UsersDto();

    }
    // ******************* the dto to model data transfer****************
    public UsersModel toUsersModel(UsersDto usersDto){
        UsersModel usersModel = new UsersModel();
        usersModel.setFirstName(usersDto.getFirstName());
        usersModel.setLastName(usersDto.getLastName());
        usersModel.setEmail(usersDto.getEmail());
        usersModel.setPassword(usersDto.getPassword());

        return usersModel;
    }

      public UsersDto toUsersDto(UsersModel usersModel){
        UsersDto usersDto = new UsersDto();
        usersDto.setUsersId(usersModel.getUsersId());
        usersDto.setFirstName(usersModel.getFirstName());
        usersDto.setLastName(usersModel.getLastName());
        usersDto.setEmail(usersModel.getEmail());
        usersDto.setPassword(usersModel.getPassword());

        return  usersDto;
    }


    // *******************the dto to model data transfer****************
}

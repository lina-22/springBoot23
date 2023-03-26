package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.UsersDto;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersManager {
    private UsersService usersService;
   /* public UsersDto createUsers(UsersDto usersDto){
        UsersModel usersToAdd = toUsersModel(usersDto);
        UsersModel addedUsers = usersService.create(usersToAdd);
        return toUsersDto(addedUsers);
//         ???
    }


    public List<UsersDto> getAllUsers() {
        List<UsersDto>usersDtoList = new ArrayList<>();
        List<UsersModel> usersModelList = usersService.findAll();
        usersModelList.forEach(data-> {
            usersDtoList.add(toUsersDto(data));
        });
        return usersDtoList;
    }
    // ******************* the dto to model data transfer****************
    public UsersModel toUsersModel(UsersDto usersDto){
        UsersModel usersModel = new UsersModel();
        usersModel.setFirst_name(usersDto.getFirst_name());
        usersModel.setLast_name(usersDto.getLast_name());
        usersModel.setEmail(usersDto.getEmail());
        usersModel.setPassword(usersDto.getPassword());

        return usersModel;
    }*/

  /*  public UsersDto toUsersDto(UsersModel usersModel){
        UsersDto usersDto = new UsersDto();
        usersDto.setId(usersModel.getId());
        usersDto.setFirst_name(usersModel.getFirst_name());
        usersDto.setLast_name(usersModel.getLast_name());
        usersDto.setEmail(usersModel.getEmail());
        usersDto.setPassword(usersModel.getPassword());

        return  usersDto;
    }*/


    // *******************the dto to model data transfer****************
}

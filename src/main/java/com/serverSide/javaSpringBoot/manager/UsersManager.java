package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import com.serverSide.javaSpringBoot.services.UsersService;
import com.serverSide.javaSpringBoot.services.securityService.UsersSecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@AllArgsConstructor
public class UsersManager {
    private UsersService usersService;
    private UsersSecurityService usersSecurityService;
    private RolesService rolesService;

    private final BCryptPasswordEncoder passwordEncoder;

    public BaseResponseDto registerUser(UserDto userDto) {
        UserModel usersToAdd = toUserModel(userDto);
        BaseResponseDto responseDto = usersSecurityService.register(usersToAdd);
        return responseDto;
    }


    public UserDto createUser(UserDto userDto) {
        UserModel usersToAdd = toUserModel(userDto);
        UserModel addedUsers = usersService.create(usersToAdd);
        return toUsersDto(addedUsers);

    }


    public List<UserDto> getAllUsers() {
        List<UserDto>usersDtoList = new ArrayList<>();
        List<UserModel> usersModelList = usersService.findAll();
        usersModelList.forEach(data-> {
            usersDtoList.add(toUsersDto(data));
        });
        return usersDtoList;
    }

    public UserDto getUsersById(long users_id) {
        return toUsersDto(usersService.findById(users_id).get());
    }

    public UserDto updateUsers(UserDto userDto) {
        Optional<UserModel> usersModel = usersService.findById(userDto.getUserId());
        if (usersModel.isPresent()) {
            usersModel.get().setFirstName(userDto.getFirstName());
            usersModel.get().setLastName(userDto.getLastName());
            usersModel.get().setEmail(userDto.getEmail());
            usersModel.get().setPassword(userDto.getPassword());
            UserModel updatedUserModel = usersService.update(usersModel.get());
            return toUsersDto(updatedUserModel);
        }
        return new UserDto();

    }

    public void deleteUserById(long users_id){
        usersService.delete(users_id);
    }

    // ******************* the dto to model data transfer****************
    public UserModel toUserModel(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(userDto.getFirstName());
        userModel.setLastName(userDto.getLastName());
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(passwordEncoder.encode(userDto.getPassword()));

        RolesModel rolesModel = rolesService.findByName(userDto.getRole());
        userModel.setRolesModel(rolesModel);

        return userModel;
    }

    public UserDto toUsersDto(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userModel.getUserId());
        userDto.setFirstName(userModel.getFirstName());
        userDto.setLastName(userModel.getLastName());
        userDto.setEmail(userModel.getEmail());
        userDto.setPassword(userModel.getPassword());
        userDto.setRole(userModel.getRolesModel().getName());
        return userDto;
    }


    // *******************the dto to model data transfer****************
}

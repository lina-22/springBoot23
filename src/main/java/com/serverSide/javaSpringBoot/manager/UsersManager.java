package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.ProfileUpdateDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.services.RolesService;
import com.serverSide.javaSpringBoot.services.UsersService;
import com.serverSide.javaSpringBoot.services.securityService.UsersSecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.coyote.http11.Constants.a;

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

    public BaseResponseDto updateUsers(UserDto userDto) {
        UserModel userModel= toUserModel(userDto);
        return usersService.update(userModel);
    }

    public void deleteUserById(long usersId){
        usersService.delete(usersId);
    }

    // ******************* the dto to model data transfer****************
    public UserModel toUserModel(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setUserId(userDto.getUserId());
        userModel.setFirstName(userDto.getFirstName());
        userModel.setLastName(userDto.getLastName());
        userModel.setEmail(userDto.getEmail());
        userModel.setPassword(passwordEncoder.encode(userDto.getPassword()));

        RolesModel rolesModel = rolesService.findByName(userDto.getRole());
        Set rolesSet = new HashSet<>(Arrays.asList(rolesModel));
        userModel.setRolesModelSet(rolesSet);

        return userModel;
    }

    public UserDto toUsersDto(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userModel.getUserId());
        userDto.setFirstName(userModel.getFirstName());
        userDto.setLastName(userModel.getLastName());
        userDto.setEmail(userModel.getEmail());
        return userDto;
    }

    // *******************the dto to model data transfer****************
}

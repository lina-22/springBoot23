package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.dto.UserDto;
import com.serverSide.javaSpringBoot.model.UserModel;
import java.util.List;
import java.util.Optional;

public interface UsersService {

     UserModel create(UserModel userModel);
     Optional<UserModel> findById(long users_id);
     List<UserModel> findAll();

     UserModel update(UserModel userModel);

     void delete(long users_id);

}

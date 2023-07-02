package com.serverSide.javaSpringBoot.services.securityService;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.model.UserModel;

public interface  UsersSecurityService {

    BaseResponseDto register(UserModel userModel);

}

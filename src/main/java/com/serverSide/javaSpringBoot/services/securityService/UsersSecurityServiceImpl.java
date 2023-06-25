package com.serverSide.javaSpringBoot.services.securityService;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.exception.BaseException;
import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.repository.RolesRepository;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersSecurityServiceImpl implements UsersSecurityService {

    private final UsersRepository userRepository;
    private final RolesRepository roleRepository;

    @Override
    public BaseResponseDto register(UserModel userModel) {
        BaseResponseDto response = new BaseResponseDto();
        validateAccount(userModel);
        try{
            userRepository.save(userModel);
            response.setCode(String.valueOf(HttpStatus.OK.value()));
            response.setMessage("Account successfully created.");
            System.out.println("test here success...");
        }catch (Exception e){
            response.setCode(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()));
            response.setMessage("Service unavailable.");
        }
        return response;
    }


    //validate null data -
    private void validateAccount(UserModel userModel){
        if (ObjectUtils.isEmpty(userModel)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Data must not be empty.");
        }
        //check duplicate user -
        UserModel user = userRepository.findByEmail(userModel.getEmail());
        if (!ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Username already exists.");
        }
        //validate role -
      /*  List<String>roles = roleRepository.findAll().stream().map(RolesModel::getName).toList();
        System.out.println("test list print : " + roles.toString());
        if (!roles.contains(userModel.getRolesModel().getName())){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Invalid role.");
        }*/
    }
}

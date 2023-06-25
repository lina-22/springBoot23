package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.dto.BaseResponseDto;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserModel create(UserModel userModel) {

        return usersRepository.save(userModel);
    }

    @Override
    public UserModel findByEmail(String email) {

        return usersRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> findAll() {

        return usersRepository.findAll();
    }

    @Override
    public BaseResponseDto update(UserModel userModel) {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        Optional<UserModel> userFound = usersRepository.findById(userModel.getUserId());
        System.out.println("test usr id... :" + userModel.getUserId());
        try{
            if(userFound.isPresent()){
            usersRepository.save(userModel);
            baseResponseDto.setCode(String.valueOf(HttpStatus.OK.value()));
            baseResponseDto.setMessage("Profile successfully updated.");
            }else {
                baseResponseDto.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
                baseResponseDto.setMessage("User not found.");
            }
        }catch( Exception e){
            baseResponseDto.setCode(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()));
            baseResponseDto.setMessage("Something went wrong!");
            System.out.println("User Service update : " + e.getMessage());
        }
        return baseResponseDto;
    }

    @Override
    public void delete(long users_id) {
        usersRepository.deleteById(users_id);
    }

}

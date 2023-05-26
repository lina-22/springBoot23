package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.Password_resetDto;
import com.serverSide.javaSpringBoot.model.Password_resetModel;
import com.serverSide.javaSpringBoot.services.Password_resetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PasswordResetManager {

    private Password_resetService password_resetService;


    public Password_resetDto createPassword_reset(Password_resetDto password_resetDto){
        Password_resetModel password_resetToAdd = toPassword_resetModel(password_resetDto);

        Password_resetModel addedPassword_reset = password_resetService.create(password_resetToAdd);
//        System.out.println("hello"+addedPassword_reset);
        return toPassword_resetDto(addedPassword_reset);

    }


    public List<Password_resetDto> getAllPassword_reset() {
        List<Password_resetDto>password_resetDtoList = new ArrayList<>();
        List<Password_resetModel> password_resetModelList = password_resetService.findAll();
        password_resetModelList.forEach(data-> {
            password_resetDtoList.add(toPassword_resetDto(data));
        });
        return password_resetDtoList;
    }

    public Password_resetDto getPassword_resetById(long password_reset_id){

        return toPassword_resetDto(password_resetService.findById(password_reset_id).get());
    }

    public Password_resetDto updatePassword_reset(Password_resetDto password_resetDto){
        Optional<Password_resetModel> password_resetModel =  password_resetService.findById(password_resetDto.getPasswordResetId());
        if (password_resetModel.isPresent()){
            password_resetModel.get().setToken(password_resetDto.getToken());
            Password_resetModel updatedCategoryModel =  password_resetService.update(password_resetModel.get());
            return toPassword_resetDto(updatedCategoryModel);
        }
        return new Password_resetDto();

    }
    public void deletePassword_resetById(long password_reset_id){

       password_resetService.delete(password_reset_id);
    }
    // ******************* the dto to model data transfer****************
    public Password_resetModel toPassword_resetModel(Password_resetDto password_resetDto){
        Password_resetModel password_resetModel = new Password_resetModel();
        password_resetModel.setToken(password_resetDto.getToken());
        return password_resetModel;
    }

    // *******************the model to dto data transfer****************
    public Password_resetDto toPassword_resetDto(Password_resetModel password_resetModel){
        Password_resetDto password_resetDto = new Password_resetDto();
        password_resetDto.setPasswordResetId(password_resetModel.getPasswordResetId());
        password_resetDto.setToken(password_resetModel.getToken());
        return  password_resetDto;
    }

}

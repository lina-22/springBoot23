package com.serverSide.javaSpringBoot.services;
import com.serverSide.javaSpringBoot.model.Password_resetModel;
import com.serverSide.javaSpringBoot.repository.Password_resetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Password_resetServiceImpl implements Password_resetService{

    @Autowired
    Password_resetRepository password_resetRepository;

    @Override
    public Password_resetModel create(Password_resetModel password_resetModel){

        return  password_resetRepository.save(password_resetModel);
    }
    @Override
    public Optional<Password_resetModel> findById(long password_resetModel){

        return password_resetRepository.findById(password_resetModel);
    }

    @Override
    public List<Password_resetModel> findAll(){

        return password_resetRepository.findAll();
    }

    @Override
    public Password_resetModel update(Password_resetModel password_resetModel){
        return  password_resetRepository.save(password_resetModel);
    }

    @Override
    public void delete(long password_resetModel) {
        password_resetRepository.deleteById(password_resetModel);
    }
}

package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<UserModel> findById(long users_id) {

        return usersRepository.findById(users_id);
    }

    @Override
    public List<UserModel> findAll() {

        return usersRepository.findAll();
    }

    @Override
    public UserModel update(UserModel userModel) {

        return usersRepository.save(userModel);
    }

    @Override
    public void delete(long users_id) {

        usersRepository.deleteById(users_id);
    }

}

package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.repository.CategoryRepository;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository mUsersRepository;

    @Override
    public UsersModel create(UsersModel usersModel){

        return  mUsersRepository.save(usersModel);
    }
    @Override
    public Optional<UsersModel> findById(Long id){

        return mUsersRepository.findById(id);
    }

    @Override
    public List<UsersModel> findAll(){

        return mUsersRepository.findAll();
    }

    @Override
    public UsersModel update(UsersModel UsersModel){

        return  mUsersRepository.save(UsersModel);
    }

    @Override
    public void delete(long id) {
        mUsersRepository.deleteById(id);
    }
    @Override
    public List<UsersModel> findAllById(List<Long> ids) {

        return mUsersRepository.findAllById(ids);
    }

}

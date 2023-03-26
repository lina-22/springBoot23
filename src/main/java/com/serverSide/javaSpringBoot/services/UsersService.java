package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.UsersModel;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    public UsersModel create(UsersModel usersModel);
    public Optional<UsersModel> findById(long users_id);

    public List<UsersModel> findAll();

    public UsersModel update(UsersModel usersModel);

    public  void delete(long users_id);

    List<UsersModel> findAllById(List<Long>ids);
}

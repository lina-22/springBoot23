package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.UserModel;
import java.util.List;
import java.util.Optional;

public interface UsersService {

    public UserModel create(UserModel userModel);
    public Optional<UserModel> findById(long users_id);
    public List<UserModel> findAll();

    public UserModel update(UserModel userModel);

    public  void delete(long users_id);

}

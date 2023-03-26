package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.Password_resetModel;

import java.util.List;
import java.util.Optional;

public interface Password_resetService {

    public Password_resetModel create(Password_resetModel password_resetModel);
    public Optional<Password_resetModel> findById(long password_reset_id);

    public List<Password_resetModel> findAll();

    public Password_resetModel update(Password_resetModel password_resetModel);

    public  void delete(long password_reset_id);

}

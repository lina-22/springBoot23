package com.serverSide.javaSpringBoot.services;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository mUsersRepository;

    @Override
    public UsersModel create(UsersModel usersModel){

        return  mUsersRepository.save(usersModel);
    }
    @Override
    public Optional<UsersModel> findById(long users_id){

        return mUsersRepository.findById(users_id);
    }

    @Override
    public List<UsersModel> findAll(){

        return mUsersRepository.findAll();
    }

    @Override
    public UsersModel update(UsersModel usersModel){

        return  mUsersRepository.save(usersModel);
    }

    @Override
    public void delete(long users_id) {
        mUsersRepository.deleteById(users_id);
    }
    @Override
    public List<UsersModel> findAllById(List<Long> ids) {

        return mUsersRepository.findAllById(ids);
    }

}

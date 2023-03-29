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
    UsersRepository usersRepository;

    @Override
    public UsersModel create(UsersModel usersModel){

        return usersRepository.save(usersModel);
    }
    @Override
    public Optional<UsersModel> findById(long users_id){

        return usersRepository.findById(users_id);
    }

    @Override
    public List<UsersModel> findAll(){

        return usersRepository.findAll();
    }

    @Override
    public UsersModel update(UsersModel usersModel){

        return  usersRepository.save(usersModel);
    }

    @Override
    public void delete(long users_id) {
        usersRepository.deleteById(users_id);
    }
    @Override
    public List<UsersModel> findAllById(List<Long> ids) {

        return usersRepository.findAllById(ids);
    }

}

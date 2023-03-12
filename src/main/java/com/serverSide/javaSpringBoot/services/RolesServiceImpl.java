package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.RolesModel;
import com.serverSide.javaSpringBoot.model.UsersModel;
import com.serverSide.javaSpringBoot.repository.RolesRepository;
import com.serverSide.javaSpringBoot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RolesServiceImpl implements RolesService{

    @Autowired
    RolesRepository mRolesRepository;

    @Override
    public RolesModel create(RolesModel rolesModel){

        return  mRolesRepository.save(rolesModel);
    }
    @Override
    public Optional<RolesModel> findById(Long id){

        return mRolesRepository.findById(id);
    }

    @Override
    public List<RolesModel> findAll(){

        return mRolesRepository.findAll();
    }

    @Override
    public RolesModel update(RolesModel rolesModel){

        return  mRolesRepository.save(rolesModel);
    }

    @Override
    public void delete(long id) {
        mRolesRepository.deleteById(id);
    }
    @Override
    public List<RolesModel> findAllById(List<Long> ids) {

        return mRolesRepository.findAllById(ids);
    }

}

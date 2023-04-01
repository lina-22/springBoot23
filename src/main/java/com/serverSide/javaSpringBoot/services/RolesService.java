package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.RolesModel;
import java.util.List;
import java.util.Optional;

public interface RolesService {

     RolesModel create(RolesModel rolesModel);
     Optional<RolesModel> findById(long roles_id);

     RolesModel findByName(String name);


     List<RolesModel> findAll();

     RolesModel update(RolesModel rolesModel);

      void delete(long roles_id);

//    List<RolesModel> findAllById(List<Long>ids);
}

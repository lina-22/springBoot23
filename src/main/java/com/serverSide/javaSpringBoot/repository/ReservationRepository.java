package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Long> {
    List<ReservationModel>findAllByUserModel(UserModel userModel);
}

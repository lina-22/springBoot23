package com.serverSide.javaSpringBoot.repository;


import com.serverSide.javaSpringBoot.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
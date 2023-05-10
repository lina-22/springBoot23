package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}

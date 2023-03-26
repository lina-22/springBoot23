package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}

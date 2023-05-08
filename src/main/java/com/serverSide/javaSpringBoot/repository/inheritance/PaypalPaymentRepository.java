package com.serverSide.javaSpringBoot.repository.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.repository.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalPaymentRepository extends PaymentRepository { }

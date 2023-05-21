package com.serverSide.javaSpringBoot.repository.inheritance;

import com.serverSide.javaSpringBoot.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaypalPaymentRepository extends PaymentRepository { }

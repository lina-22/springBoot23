package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.PaymentModel;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    public PaymentModel create(PaymentModel paymentModel);
    public Optional<PaymentModel> findById(Long payment_id);

    public List<PaymentModel> findAll();

    public PaymentModel update(PaymentModel paymentModel);

    public  void delete(long payment_id);
}

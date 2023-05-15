/*
package com.serverSide.javaSpringBoot.services.inheritance;
import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public PaymentModel create(PaymentModel paymentModel){
        return  paymentRepository.save(paymentModel);
    }
    @Override
    public Optional<PaymentModel> findById(long paymentModel){
        return paymentRepository.findById(paymentModel);
    }

    @Override
    public List<PaymentModel> findAll(){
        return paymentRepository.findAll();
    }

    @Override
    public PaymentModel update(PaymentModel paymentModel){
        return  paymentRepository.save(paymentModel);
    }

    @Override
    public void delete(long paymentModel) {
        paymentRepository.deleteById(paymentModel);
    }
}
*/

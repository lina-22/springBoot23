package com.serverSide.javaSpringBoot.services.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.repository.inheritance.PaypalPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaypalPaymentServiceImpl implements PaypalPaymentService{

    private final PaypalPaymentRepository paymentRepository;
    @Override
    public PaypalPaymentModel createPaypalPayment(PaypalPaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }
}

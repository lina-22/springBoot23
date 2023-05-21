package com.serverSide.javaSpringBoot.services.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.StripePaymentModel;
import com.serverSide.javaSpringBoot.repository.inheritance.StripePaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StripePaymentServiceImpl implements StripePaymentService {

    private final StripePaymentRepository paymentRepository;
    public StripePaymentModel createStripePayment(StripePaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }
}

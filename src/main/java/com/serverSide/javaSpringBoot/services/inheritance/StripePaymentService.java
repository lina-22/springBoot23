package com.serverSide.javaSpringBoot.services.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.StripePaymentModel;

public interface StripePaymentService {

    StripePaymentModel createStripePayment(StripePaymentModel paymentModel);
}

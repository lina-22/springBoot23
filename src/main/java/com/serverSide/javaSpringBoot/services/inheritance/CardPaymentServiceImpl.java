
package com.serverSide.javaSpringBoot.services.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.CardPaymentModel;
import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.repository.inheritance.CardPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CardPaymentServiceImpl implements CardPaymentService{

   private final CardPaymentRepository paymentRepository;

   @Override
    public CardPaymentModel createCardPayment(CardPaymentModel paymentModel){
       return paymentRepository.save(paymentModel);
   }


}


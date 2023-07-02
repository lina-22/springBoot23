package com.serverSide.javaSpringBoot.manager;
import com.serverSide.javaSpringBoot.dto.inheritance.PaypalPaymentDto;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.services.ReservationService;
import com.serverSide.javaSpringBoot.services.inheritance.PaypalPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PaymentManager {

    private final ReservationService reservationService;
    private final PaypalPaymentService paypalPaymentService;

    public PaypalPaymentDto createPayPalPayment(PaypalPaymentDto paypalPaymentDto){

        Optional<ReservationModel> reservationModel =  reservationService.findById(paypalPaymentDto.getReservationId());
        PaypalPaymentModel paypalPaymentModel = new PaypalPaymentModel();
        paypalPaymentModel.setAccount_email(paypalPaymentDto.getAccountEmail());
        paypalPaymentModel.setAmount(paypalPaymentDto.getAmount());
        paypalPaymentModel.setDetails(paypalPaymentDto.getDetails());

        PaypalPaymentModel paymentModel = paypalPaymentService.createPaypalPayment(paypalPaymentModel);
        return toDto(paymentModel);
    }

    PaypalPaymentDto toDto(PaypalPaymentModel paymentModel){

        PaypalPaymentDto paypalPaymentDto = new PaypalPaymentDto();
        paypalPaymentDto.setPaymentId(paymentModel.getPaymentId());
        paypalPaymentDto.setAmount(paymentModel.getAmount());
        paypalPaymentDto.setPaymentDate(paymentModel.getDatePayment());
        paypalPaymentDto.setDetails(paymentModel.getDetails());
        return paypalPaymentDto;
    }

}

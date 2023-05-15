package com.serverSide.javaSpringBoot.manager;


import com.serverSide.javaSpringBoot.dto.inheritance.PaypalPaymentDto;
import com.serverSide.javaSpringBoot.model.ReservationModel;
import com.serverSide.javaSpringBoot.model.UserModel;
import com.serverSide.javaSpringBoot.model.inheritance.PaypalPaymentModel;
import com.serverSide.javaSpringBoot.services.ReservationService;
import com.serverSide.javaSpringBoot.services.UsersService;
import com.serverSide.javaSpringBoot.services.inheritance.PaypalPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PaymentManager {

    private final UsersService usersService;
    private final ReservationService reservationService;
    private final PaypalPaymentService paypalPaymentService;

    public PaypalPaymentDto createPayPalPayment(PaypalPaymentDto paypalPaymentDto){
        Optional<UserModel> userModel = usersService.findById(paypalPaymentDto.getUserId());
        List<ReservationModel> reservationModelSet =  reservationService.findAllByIds(paypalPaymentDto.getReservationIds());
        Set<ReservationModel>reservationModels = new HashSet<>(reservationModelSet);

        PaypalPaymentModel paypalPaymentModel = new PaypalPaymentModel();

        paypalPaymentModel.setDatePayment(new Date(12/10/2023));

        paypalPaymentModel.setAccount_email(paypalPaymentDto.getAccountEmail());

        paypalPaymentModel.setAmount(paypalPaymentDto.getAmount());
        paypalPaymentModel.setDetails(paypalPaymentDto.getDetails());
        System.out.println("test here : " + paypalPaymentModel.toString() + " " +paypalPaymentDto.getAccountEmail());
        paypalPaymentModel.setUserModel(userModel.get());
        paypalPaymentModel.setReservationModel(reservationModels);

        PaypalPaymentModel paymentModel = paypalPaymentService.createPaypalPayment(paypalPaymentModel);
        return toDto(paymentModel);
    }

    PaypalPaymentDto toDto(PaypalPaymentModel paymentModel){
        List<Long> reservationIds = new ArrayList<>();
        paymentModel.getReservationModel().forEach(reservationModel -> {
            reservationIds.add(reservationModel.getReservationId());
        });
        PaypalPaymentDto paypalPaymentDto = new PaypalPaymentDto();
        paypalPaymentDto.setPaymentId(paymentModel.getPaymentId());
        paypalPaymentDto.setAmount(paymentModel.getAmount());
        paypalPaymentDto.setPaymentDate(paymentModel.getDatePayment());
        paypalPaymentDto.setDetails(paymentModel.getDetails());
        paypalPaymentDto.setReservationIds(reservationIds);
        paypalPaymentDto.setUserId(paymentModel.getUserModel().getUserId());
        return paypalPaymentDto;
    }

//    private PaymentService paymentService;

    //public PaymentDto createPayment(PaymentDto paymentDto){

      //  PaymentModel paymentToAdd = toPaymentModel(paymentDto);

  /*
       PaymentModel paypalPayment = new PaypalPaymentModel(1L, 1014, new Date(12/12/2023), "test_details", null , null, "test@mail.com");
        paymentRepository.save(paypalPayment);
       PaymentModel paymentModel = new PaymentModel();
        paymentModel.setAmount(paymentDto.getAmount());
        paymentModel.setDetails(paymentDto.getDetails());
        paymentModel.setDatePayment(paymentDto.getDatePayment());
        PaymentModel addedPayment = paymentService.create(paymentModel);

        PaymentDto savedPaymentDto = new PaymentDto();
        savedPaymentDto.setPaymentId(addedPayment.getPaymentId());
        savedPaymentDto.setAmount(addedPayment.getAmount());
        savedPaymentDto.setDetails(addedPayment.getDetails());
        savedPaymentDto.setDatePayment(addedPayment.getDatePayment());

        return  savedPaymentDto;
    }
*/

  /*  public List<PaymentDto> getAllPayment(){
        List<PaymentDto>paymentDtoList = new ArrayList<>();
        List<PaymentModel>paymentModelList = paymentService.findAll();
        paymentModelList.forEach(data->{

            PaymentDto paymentDto = new PaymentDto();
            paymentDto.setPaymentId(data.getPaymentId());
            paymentDto.setAmount(data.getAmount());
            paymentDto.setDetails(data.getDetails());
            paymentDto.setDatePayment(data.getDatePayment());

            paymentDtoList.add(paymentDto);
        });
        return paymentDtoList;
    }
*/
  /*  public PaymentDto getPaymentById(long payment_id){
PaymentModel paymentModel = paymentService.findById(payment_id).get();
PaymentModel paymentModel1 = paymentService.findById(payment_id).get();
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(paymentModel1.getPaymentId());
        paymentDto.setAmount(paymentModel1.getAmount());
        paymentDto.setDetails(paymentModel1.getDetails());
        paymentDto.setDatePayment(paymentModel1.getDatePayment());
        return paymentDto;
    }
*/
  /*  public PaymentDto updatePayment(PaymentDto paymentDto){
        Optional<PaymentModel> paymentModel =  paymentService.findById(paymentDto.getPaymentId());
        if (paymentModel.isPresent()){
            paymentModel.get().setAmount(paymentDto.getAmount());
            paymentModel.get().setDetails(paymentDto.getDetails());
            paymentModel.get().setDatePayment(paymentDto.getDatePayment());
            PaymentModel updatedPaymentModel =  paymentService.update(paymentModel.get());
            return toPaymentDto(updatedPaymentModel);
        }
        return new PaymentDto();

    }
*/
  /*  public void deletePaymentById(long payment_id){

        paymentService.delete(payment_id);
    }*/
    // ******************* the dto to model data transfer****************
    /*public PaymentModel toPaymentModel(PaymentDto paymentDto){
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setAmount(paymentDto.getAmount());
        paymentModel.setDetails(paymentDto.getDetails());
        paymentModel.setDatePayment(paymentDto.getDatePayment());
        return paymentModel;
    }

    public PaymentDto toPaymentDto(PaymentModel paymentModel){
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(paymentModel.getPaymentId());
        paymentDto.setAmount(paymentModel.getAmount());
        paymentDto.setDetails(paymentModel.getDetails());
        paymentDto.setDatePayment(paymentModel.getDatePayment());
        return  paymentDto;
    }*/
}

package com.serverSide.javaSpringBoot.manager;


import com.serverSide.javaSpringBoot.dto.PaymentDto;
import com.serverSide.javaSpringBoot.model.PaymentModel;
import com.serverSide.javaSpringBoot.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentManager {


    private PaymentService paymentService;

    public PaymentDto createPayment(PaymentDto paymentDto){

      //  PaymentModel paymentToAdd = toPaymentModel(paymentDto);

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


    public List<PaymentDto> getAllPayment(){
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

    public PaymentDto getPaymentById(long payment_id){
PaymentModel paymentModel = paymentService.findById(payment_id).get();
PaymentModel paymentModel1 = paymentService.findById(payment_id).get();
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(paymentModel1.getPaymentId());
        paymentDto.setAmount(paymentModel1.getAmount());
        paymentDto.setDetails(paymentModel1.getDetails());
        paymentDto.setDatePayment(paymentModel1.getDatePayment());
        return paymentDto;
    }

    public PaymentDto updatePayment(PaymentDto paymentDto){
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

    public void deletePaymentById(long payment_id){

        paymentService.delete(payment_id);
    }
    // ******************* the dto to model data transfer****************
    public PaymentModel toPaymentModel(PaymentDto paymentDto){
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
    }
}

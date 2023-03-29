package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.PaymentDto;
import com.serverSide.javaSpringBoot.manager.PaymentManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {
    private final PaymentManager paymentManager;

    @PostMapping
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto){
        return paymentManager.createPayment(paymentDto);
    }

    @GetMapping
    public List<PaymentDto> getAllPayment(){

        return paymentManager.getAllPayment();
    }


    @GetMapping(path = "/{payment_id}")
    public PaymentDto getPaymentById(@PathVariable long payment_id){

        return paymentManager.getPaymentById(payment_id);
    }

    @PutMapping
    public PaymentDto updatePaymentById(@RequestBody PaymentDto paymentDto){

        return paymentManager.updatePayment(paymentDto);
}
}

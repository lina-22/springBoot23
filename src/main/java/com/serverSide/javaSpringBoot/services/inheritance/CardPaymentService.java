package com.serverSide.javaSpringBoot.services.inheritance;

import com.serverSide.javaSpringBoot.model.inheritance.CardPaymentModel;

import java.util.List;
import java.util.Optional;

public interface CardPaymentService {

    public CardPaymentModel create(CardPaymentModel cardPaymentModel);

    public Optional<CardPaymentModel> findById(long account_number);

    public List<CardPaymentModel> findAll();

    public CardPaymentModel update(CardPaymentModel cardPaymentModel);

    public void delete(long account_number);


}

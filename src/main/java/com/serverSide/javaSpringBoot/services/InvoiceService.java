package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.InvoiceModel;


import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    InvoiceModel create(InvoiceModel invoiceModel);
    Optional<InvoiceModel> findById(long invoice_id);

    List<InvoiceModel> findAll();

    InvoiceModel update(InvoiceModel invoiceModel);

    void delete(long invoice_id);
}

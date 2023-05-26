package com.serverSide.javaSpringBoot.services;


import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    InvoiceRepository invoiceRepository;

    @Override
    public InvoiceModel create(InvoiceModel invoiceModel) {

        return invoiceRepository.save(invoiceModel);
    }

    @Override
    public Optional<InvoiceModel> findById(long invoice_id) {
        return invoiceRepository.findById(invoice_id);
    }

    @Override
    public List<InvoiceModel> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public InvoiceModel update(InvoiceModel invoiceModel) {
        return invoiceRepository.saveAndFlush(invoiceModel);
    }

    @Override
    public void delete(long invoice_id) {
        invoiceRepository.deleteById(invoice_id);

    }
}

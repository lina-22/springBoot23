package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.SupplierModel;
import com.serverSide.javaSpringBoot.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService{

    SupplierRepository supplierRepository;

    @Override
    public SupplierModel create(SupplierModel supplierModel) {
        return supplierRepository.save(supplierModel);
    }

    @Override
    public Optional<SupplierModel> findById(long supplier_id) {
        return supplierRepository.findById(supplier_id);
    }

    @Override
    public List<SupplierModel> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public SupplierModel update(SupplierModel supplierModel) {
        return supplierRepository.saveAndFlush(supplierModel);
    }

    @Override
    public void delete(long supplier_id) {
        supplierRepository.deleteById(supplier_id);
    }
}

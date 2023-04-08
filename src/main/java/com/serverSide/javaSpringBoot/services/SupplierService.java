package com.serverSide.javaSpringBoot.services;

import com.serverSide.javaSpringBoot.model.CategoryModel;
import com.serverSide.javaSpringBoot.model.SupplierModel;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    SupplierModel create(SupplierModel supplierModel);
    Optional<SupplierModel> findById(long supplier_id);

    List<SupplierModel> findAll();

    SupplierModel update(SupplierModel supplierModel);

    void delete(long supplier_id);


}

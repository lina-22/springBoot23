package com.serverSide.javaSpringBoot.repository;

import com.serverSide.javaSpringBoot.model.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
}

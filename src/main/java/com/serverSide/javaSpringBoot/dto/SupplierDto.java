package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {
    private long supplierId;
    private  String supplierCountry;
    private  String companyName;
    private  String contactName;
    private  String contactTitle;
    private  String address;
    private  String region;
    private  String postalCode;
    private  String phone;
    private  String fax;
}

package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class SupplierModel {

    @Id
    @Column(name ="supplier_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;

    @Column(name="supplier_country", nullable = false)
    private  String supplierCountry;

    @Column(name="company_name", nullable = false)
    private  String companyName;

    @Column(name="contact_name", nullable = false)
    private  String contactName;

    @Column(name="contact_title", nullable = false)
    private  String contactTitle;

    @Column(name="address", nullable = false)
    private  String address;

    @Column(name="city", nullable = false)
    private  String region;

    @Column(name="postal_code", nullable = false)
    private  String postalCode;

    @Column(name="phone", nullable = false)
    private  String phone;

    @Column(name="fax", nullable = false)
    private  String fax;

    @OneToMany(mappedBy = "supplierModel", fetch = FetchType.LAZY)
    private Set<ProductModel> ProductModel = new HashSet<>();

}

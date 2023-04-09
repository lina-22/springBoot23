package com.serverSide.javaSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private long id;
    private Date createDate;
    private Date updateDate;
    private String reference;
    private String status;
    private BigDecimal tax;
    private BigDecimal subTotal;
}

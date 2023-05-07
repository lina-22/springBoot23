package com.serverSide.javaSpringBoot.model;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class InvoiceModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;

    @Column
    private Date createDate;

    @Column
    private Date updateDate;

    @Column
    private String reference;

    @Column
    private String status;

    @Column
    private BigDecimal tax;

    @Column
    private BigDecimal subTotal;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_res_id", referencedColumnName = "reservation_id")
    private ReservationModel reservationModel;

}

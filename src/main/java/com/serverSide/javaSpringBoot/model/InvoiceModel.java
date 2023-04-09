package com.serverSide.javaSpringBoot.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "invoice")
public class Invoice {
    @Transient
    private static final String sequenceName = "invoice_id_seq";

    @Id
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_id", nullable = false)
    private Order order;

    @Column(name = "ord_id", insertable = false, updatable = false)
    private Integer orderId;

    @Column(name = "amount",precision=8, scale=2)
    private Double amount;

    @Column(name = "issued_date", nullable = false)
    private Date issuedDate;
    @Column(name = "due_date", nullable = false)
    private Date dueDate;


}

package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "details")
public class Details {
    @Transient
    private static final String sequenceName = "details_id_seq";

    @Id
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ord_id",updatable = false,insertable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",updatable = false,insertable=false)
    private Product product;

    @Column(name = "ord_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private short quantity;
}


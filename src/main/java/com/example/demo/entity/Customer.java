package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Transient
    private static final String sequenceName = "customer_id_seq";

    @Id
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Integer id;

    @Column(name = "name",length =14)
    private String name;

    @Column(name = "country",columnDefinition = "CHAR(3)")
    private String country;

    @Column(name = "address",columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone",length =50)
    private String phone;

    @OneToMany(mappedBy="customer")
    private List<Order> orders;
}

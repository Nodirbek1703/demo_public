package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Transient
    private static final String sequenceName = "product_id_seq";

    @Id
    @SequenceGenerator(name = sequenceName, sequenceName = sequenceName, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequenceName)
    private Integer id;

    @Column(name = "name",length =10)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable = false)
    private Category category;

    @Column(name = "cat_id", insertable = false, updatable = false)
    private Integer categoryId;

    @Column(name = "description",length =20)
    private String description;

    @Column(name = "price",precision=6, scale=2)
    private Double price;

    @Column(name = "photo",length =1024)
    private String photo;
}

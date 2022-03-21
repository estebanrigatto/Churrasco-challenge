package com.churrasco.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Long SKU;
    @Column(unique = true)
    private Integer code;
    private String name;
    private String description;
    private String picture;
    private BigDecimal price;
    private String currency;

}

package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Section10Order {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Section10Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Section10Product product;

}

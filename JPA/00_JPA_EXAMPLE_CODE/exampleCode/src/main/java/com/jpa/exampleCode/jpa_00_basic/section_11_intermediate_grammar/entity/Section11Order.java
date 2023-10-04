package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Section11Order {

    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Section11Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Section11Product product;
}

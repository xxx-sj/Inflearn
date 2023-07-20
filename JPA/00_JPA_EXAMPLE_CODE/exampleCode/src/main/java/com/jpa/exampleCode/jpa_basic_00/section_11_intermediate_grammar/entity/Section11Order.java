package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Address;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Product;
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

package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Section11Address {
    private String city;
    private String street;
    private String zipcode;
}

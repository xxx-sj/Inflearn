package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Section10Address {

    private String city;
    private String street;
    private String zipcode;
}

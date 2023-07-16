package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Section10Address {

    private String city;
    private String street;
    private String zipcode;
}

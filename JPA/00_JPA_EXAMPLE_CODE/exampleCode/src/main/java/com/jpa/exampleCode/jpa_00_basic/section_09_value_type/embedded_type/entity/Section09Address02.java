package com.jpa.exampleCode.jpa_00_basic.section_09_value_type.embedded_type.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Section09Address02 {

    private String city;
    private String street;
    private String zipcode;

    @OneToOne
    @JoinColumn(name ="test_entity_id", insertable = false, updatable = false)
    private Section09TestEntity testEntity;

}


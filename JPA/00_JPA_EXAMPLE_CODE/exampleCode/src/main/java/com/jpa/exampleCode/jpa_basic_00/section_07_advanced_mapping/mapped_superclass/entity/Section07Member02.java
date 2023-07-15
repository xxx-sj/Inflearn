package com.jpa.exampleCode.jpa_basic_00.section_07_advanced_mapping.mapped_superclass.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Section07Member02 extends Section07BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}

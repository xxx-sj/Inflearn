package com.jpa.exampleCode.jpa_basic_00.section_07_advanced_mapping.Inheritance_mapping.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Section07Item01 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

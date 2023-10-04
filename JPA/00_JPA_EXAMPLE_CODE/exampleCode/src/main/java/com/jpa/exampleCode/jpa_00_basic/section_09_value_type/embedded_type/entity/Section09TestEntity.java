package com.jpa.exampleCode.jpa_00_basic.section_09_value_type.embedded_type.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Section09TestEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String testEntityName;
}

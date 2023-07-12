package com.jpa.exampleCode.jpa_basic_00.section_07_advanced_mapping.Inheritance_mapping.entity;

import javax.persistence.Entity;

@Entity
public class Section07Album01 extends Section07Item01 {
    private String artist;
}

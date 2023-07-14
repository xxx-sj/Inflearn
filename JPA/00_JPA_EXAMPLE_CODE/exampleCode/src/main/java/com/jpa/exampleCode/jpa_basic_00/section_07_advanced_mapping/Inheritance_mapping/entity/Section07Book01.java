package com.jpa.exampleCode.jpa_basic_00.section_07_advanced_mapping.Inheritance_mapping.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Section07Book01 extends Section07Item01{
    private String author;
    private String isbn;
}

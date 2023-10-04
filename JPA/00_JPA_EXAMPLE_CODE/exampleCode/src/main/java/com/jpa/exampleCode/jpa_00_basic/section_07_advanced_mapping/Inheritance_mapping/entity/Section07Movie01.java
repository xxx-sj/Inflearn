package com.jpa.exampleCode.jpa_00_basic.section_07_advanced_mapping.Inheritance_mapping.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Section07Movie01 extends Section07Item01{
    private String director;
    private String actor;
}

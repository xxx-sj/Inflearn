package com.jpa.exampleCode.jpa_basic_00.section_09_value_type.value_type_collection.entity;


import com.jpa.exampleCode.jpa_basic_00.section_09_value_type.value_type_comparison.entity.Section09Address04;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Section09AddressHistory {

    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Section09Address04 address;
}

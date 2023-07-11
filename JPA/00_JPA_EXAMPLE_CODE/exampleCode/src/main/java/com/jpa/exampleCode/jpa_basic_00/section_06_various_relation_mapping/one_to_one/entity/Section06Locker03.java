package com.jpa.exampleCode.jpa_basic_00.section_06_various_relation_mapping.one_to_one.entity;

import com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.entity.Section05Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.valueextraction.UnwrapByDefault;

@Entity
@Getter
@Setter
public class Section06Locker03 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Section06Member03 member;
}

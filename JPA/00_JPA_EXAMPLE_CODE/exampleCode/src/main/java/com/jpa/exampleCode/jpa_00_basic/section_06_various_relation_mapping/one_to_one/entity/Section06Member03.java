package com.jpa.exampleCode.jpa_00_basic.section_06_various_relation_mapping.one_to_one.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Section06Member03 {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private Section06Locker03 locker;
}

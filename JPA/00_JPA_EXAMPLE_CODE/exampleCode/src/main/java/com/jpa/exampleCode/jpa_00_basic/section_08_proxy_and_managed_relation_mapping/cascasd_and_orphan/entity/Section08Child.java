package com.jpa.exampleCode.jpa_00_basic.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Section08Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Section08Parent parent;
}

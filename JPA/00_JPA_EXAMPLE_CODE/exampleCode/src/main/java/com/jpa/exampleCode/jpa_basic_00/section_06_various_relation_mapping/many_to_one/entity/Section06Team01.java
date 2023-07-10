package com.jpa.exampleCode.jpa_basic_00.section_06_various_relation_mapping.many_to_one.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Section06Team01 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Section06Member01> members = new ArrayList<>();
}

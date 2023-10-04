package com.jpa.exampleCode.jpa_00_basic.section_06_various_relation_mapping.example03;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Section06Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Section06Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Section06Category> children = new ArrayList<>();
}

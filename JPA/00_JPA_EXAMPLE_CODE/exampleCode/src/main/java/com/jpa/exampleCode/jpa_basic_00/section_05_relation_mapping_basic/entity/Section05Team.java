package com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Section05Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Section05Member> memberList = new ArrayList<>();

    public Section05Team(String name) {
        this.name = name;
    }


}

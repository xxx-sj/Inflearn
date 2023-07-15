package com.jpa.exampleCode.jpa_basic_00.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Section08Parent {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section08Child> childList = new ArrayList<>();

    public void addChild(Section08Child child) {
        childList.add(child);
        child.setParent(this);
    }
}

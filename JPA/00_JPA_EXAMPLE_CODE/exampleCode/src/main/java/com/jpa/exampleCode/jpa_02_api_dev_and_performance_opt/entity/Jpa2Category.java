package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity;


import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.item.Jpa2Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Jpa2Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Jpa2Item> items = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Jpa2Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Jpa2Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Jpa2Category child) {
        this.child.add(child);
        child.setParent(this);
    }

}

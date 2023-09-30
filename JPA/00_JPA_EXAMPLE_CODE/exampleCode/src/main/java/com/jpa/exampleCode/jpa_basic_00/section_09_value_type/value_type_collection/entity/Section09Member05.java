package com.jpa.exampleCode.jpa_basic_00.section_09_value_type.value_type_collection.entity;

import com.jpa.exampleCode.jpa_basic_00.section_09_value_type.embedded_type.entity.Section09Address02;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Section09Member05 {

    @Id
    @GeneratedValue
    private Long id;


    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//    @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Section09Address02> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<Section09AddressHistory> addressHistories = new ArrayList<>();
}

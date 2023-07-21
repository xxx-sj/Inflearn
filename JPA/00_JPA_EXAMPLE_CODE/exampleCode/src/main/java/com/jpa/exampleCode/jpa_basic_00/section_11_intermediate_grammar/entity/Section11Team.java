package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Section11Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team")
    private List<Section11Member> memberList = new ArrayList<>();
}

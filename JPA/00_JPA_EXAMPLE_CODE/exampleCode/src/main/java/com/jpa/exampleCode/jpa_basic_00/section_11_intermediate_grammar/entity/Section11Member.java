package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Team;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(of = {"id", "username", "age"})
@NamedQuery(
        name = "Member.findByUsername",
        query = "select m from Section11Member m where m.username = :username"
)
public class Section11Member {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Section11Team team;

    @Enumerated(EnumType.STRING)
    private Section11MemberType type;
    public void changeTeam(Section11Team team) {
        this.team = team;
        team.getMemberList().add(this);
    }
}

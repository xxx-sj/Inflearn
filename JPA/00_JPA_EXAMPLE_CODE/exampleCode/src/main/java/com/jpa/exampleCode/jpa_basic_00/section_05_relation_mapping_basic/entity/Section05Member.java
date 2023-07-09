package com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Section05Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Section05Team team;

    @Builder
    public Section05Member(String name) {
        this.name = name;
    }

    public void changeTeam(Section05Team team) {
        this.team = team;
        team.getMemberList().add(this);
    }

}

package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class DataTeam {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    public DataTeam(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "team")
    private List<DataMember> members = new ArrayList<>();
}

package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class DataMember {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private DataTeam team;

    public DataMember(String username) {
        this.username = username;
    }

    public DataMember(String username, int age, DataTeam team) {
        this.username = username;
        this.age = age;
        if(team != null) {
            this.changeTeam(team);
        }
    }

    public DataMember(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public void changeUserName(String username) {
        this.username = username;
    }

    public void changeTeam(DataTeam team) {
        this.team = team;
        team.getMembers().add(this);
    }
}

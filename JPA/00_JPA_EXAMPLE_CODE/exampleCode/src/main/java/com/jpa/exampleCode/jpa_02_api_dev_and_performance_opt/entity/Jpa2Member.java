package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Jpa2Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Jpa2Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Jpa2Order> orders = new ArrayList<>();

}


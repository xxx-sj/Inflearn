package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class DataMember {

    @Id @GeneratedValue
    private Long id;

    private String username;

    protected DataMember() {}

    public DataMember(String username) {
        this.username = username;
    }

    public void changeUserName(String username) {
        this.username = username;
    }
}

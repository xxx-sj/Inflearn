package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.projection_select.dto;

import lombok.Getter;

@Getter
public class Section10MemberDto {

    public Section10MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }

    private String username;
    private int age;
}

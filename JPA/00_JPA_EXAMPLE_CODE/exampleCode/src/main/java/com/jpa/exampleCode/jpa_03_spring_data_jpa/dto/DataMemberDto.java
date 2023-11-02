package com.jpa.exampleCode.jpa_03_spring_data_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataMemberDto {
    private Long id;
    private String username;
    private String teamName;

    public DataMemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }
}

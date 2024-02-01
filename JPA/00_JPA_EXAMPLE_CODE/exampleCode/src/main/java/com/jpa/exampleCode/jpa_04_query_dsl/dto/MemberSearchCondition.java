package com.jpa.exampleCode.jpa_04_query_dsl.dto;

import lombok.Data;

@Data
public class MemberSearchCondition {

    //회원명, 팀명, 나이(ageGoe, ageLoe)
    private String username;
    private String teamName;
    private Integer ageGoe;
    private Integer ageLoe;
}

package com.jpa.exampleCode.jpa_04_query_dsl.repository;

import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberSearchCondition;
import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
}

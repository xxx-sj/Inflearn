package com.jpa.exampleCode.jpa_04_query_dsl.controller;

import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberSearchCondition;
import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberTeamDto;
import com.jpa.exampleCode.jpa_04_query_dsl.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }
}

package com.jpa.exampleCode.jpa_04_query_dsl.controller;

import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberSearchCondition;
import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberTeamDto;
import com.jpa.exampleCode.jpa_04_query_dsl.repository.MemberJpaRepository;
import com.jpa.exampleCode.jpa_04_query_dsl.repository.Section04MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final Section04MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }

    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPageSimple(condition, pageable);
    }

    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPageComplex(condition, pageable);
    }
}

package com.jpa.exampleCode.jpa_04_query_dsl.repository;

import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberSearchCondition;
import com.jpa.exampleCode.jpa_04_query_dsl.dto.MemberTeamDto;
import com.jpa.exampleCode.jpa_04_query_dsl.entity.Member;
import com.jpa.exampleCode.jpa_04_query_dsl.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void basicTest() {
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        Assertions.assertEquals(member, findMember);

        List<Member> result1 = memberJpaRepository.findAll();
        Assertions.assertEquals(result1.get(0), member);

        List<Member> result2 = memberJpaRepository.findByUsername("member1");
        Assertions.assertEquals(result2.get(0), member);

    }


    @Test
    public void basic_querydsl_test() {
        Member member = new Member("member1", 10);
        memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.findById(member.getId()).get();
        Assertions.assertEquals(member, findMember);

        List<Member> result1 = memberJpaRepository.findAll_querydsl();
        Assertions.assertEquals(result1.get(0), member);

        List<Member> result2 = memberJpaRepository.findByUsername_querydsl("member1");
        Assertions.assertEquals(result2.get(0), member);
    }

    @Test
    public void search_test() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);

        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<MemberTeamDto> result = memberJpaRepository.searchByBuilder(condition);

        Assertions.assertEquals(result.get(0).getUsername(), "member4");
    }

}
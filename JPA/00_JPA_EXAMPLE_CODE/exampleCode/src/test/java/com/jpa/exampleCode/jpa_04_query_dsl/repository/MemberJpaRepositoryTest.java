package com.jpa.exampleCode.jpa_04_query_dsl.repository;

import com.jpa.exampleCode.jpa_04_query_dsl.entity.Member;
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

}
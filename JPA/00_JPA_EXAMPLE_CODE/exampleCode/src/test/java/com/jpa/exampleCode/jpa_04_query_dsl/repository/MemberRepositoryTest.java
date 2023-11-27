package com.jpa.exampleCode.jpa_04_query_dsl.repository;

import com.jpa.exampleCode.jpa_04_query_dsl.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    Section04MemberRepository memberRepository;


    @Test
    public void basicTest() {
        Member member = new Member("member1", 10);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();
        Assertions.assertEquals(member, findMember);

        List<Member> result1 = memberRepository.findAll();
        Assertions.assertEquals(result1.get(0), member);

        List<Member> member1 = memberRepository.findByUsername("member1");
        Assertions.assertEquals(member1.get(0), member);
    }
}
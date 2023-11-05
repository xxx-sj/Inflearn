package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_05_next.spring_data_jpa_intro.MemberRepository;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.repository.DataMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DataMemberTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    DataMemberRepository memberRepository;

    @Test
    public void testEntity() {
        DataTeam teamA = new DataTeam("teamA");
        DataTeam teamB = new DataTeam("teamB");
        em.persist(teamA);
        em.persist(teamB);

        DataMember member1 = new DataMember("member1", 10, teamA);
        DataMember member2 = new DataMember("member2", 20, teamA);
        DataMember member3 = new DataMember("member3", 30, teamB);
        DataMember member4 = new DataMember("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<DataMember> members = em.createQuery("select m from DataMember m", DataMember.class)
                .getResultList();

        for (DataMember member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
        }
    }

    @Test
    public void jpaEventBaseEntity() throws InterruptedException {
        //given
        DataMember member = new DataMember("member1");
        memberRepository.save(member); //@PrePersist

        Thread.sleep(100);
        member.setUsername("member2");
        //when

        em.flush(); //@Preupdate
        em.clear();
        //then

        DataMember findMember = memberRepository.findById(member.getId()).get();

        System.out.println("findMember.getCreatedDate() = " + findMember.getCreatedDate());
        System.out.println("findMember.getUpdateDate() = " + findMember.getLastModifiedDate());
        System.out.println("findMember.getUsername() = " + findMember.getUsername());
        System.out.println("findMember.getCreatedBy() = " + findMember.getCreatedBy());
        System.out.println("findMember.getLastModifiedBy() = " + findMember.getLastModifiedBy());

    }

}
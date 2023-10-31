package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import org.junit.jupiter.api.Test;
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

}
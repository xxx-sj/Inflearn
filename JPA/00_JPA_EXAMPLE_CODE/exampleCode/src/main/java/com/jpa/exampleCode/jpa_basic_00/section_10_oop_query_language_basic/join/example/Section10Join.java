package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.join.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section10Join {

    @PersistenceContext
    private EntityManager em;

    public void innerJoin() {
        Section10Team team = new Section10Team();
        team.setName("teamA");
        em.persist(team);

        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);

        member.setTeam(team);

        em.persist(member);

        em.flush();
        em.clear();

        List resultList = em.createQuery("select m from Section10Member m inner join m.team t")
                .getResultList();

    }

    public void leftOuterJoin() {
        Section10Team team = new Section10Team();
        team.setName("teamA");
        em.persist(team);

        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);

        member.setTeam(team);

        em.persist(member);

        em.flush();
        em.clear();

        em.createQuery("select m from Section10Member m left join m.team t")
                .getResultList();
    }

    public void thetaJoin() {
        Section10Team team = new Section10Team();
        team.setName("teamA");
        em.persist(team);

        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);

        member.setTeam(team);

        em.persist(member);

        em.flush();
        em.clear();

        em.createQuery("select m from Section10Member m, Section10Team t where" +
                        " m.username = t.name")
                .getResultList();
    }

    public void onJoin() {
        Section10Team team = new Section10Team();
        team.setName("teamA");
        em.persist(team);

        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);

        member.setTeam(team);

        em.persist(member);

        em.flush();
        em.clear();

        em.createQuery("select m from Section10Member m left join m.team t on t.name = 'teamA'")
                .getResultList();
    }

    public void nonRelationJoin() {
        Section10Team team = new Section10Team();
        team.setName("teamA");
        em.persist(team);

        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);

        member.setTeam(team);

        em.persist(member);

        em.flush();
        em.clear();

        em.createQuery("select m from Section10Member m left join Section10Team t on m.username = t.name")
                .getResultList();
    }
}

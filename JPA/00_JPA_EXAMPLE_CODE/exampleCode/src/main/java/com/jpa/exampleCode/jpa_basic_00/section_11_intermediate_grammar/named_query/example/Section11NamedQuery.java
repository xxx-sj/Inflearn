package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.named_query.example;

import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Member;
import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section11NamedQuery {

    @PersistenceContext
    private EntityManager em;

    public void namedQuery() {
        this.insert();

        List<Section11Member> resultList = em.createNamedQuery("Member.findByUsername", Section11Member.class)
                .setParameter("username", "user1")
                .getResultList();

        for (Section11Member section11Member : resultList) {
            System.out.println("section11Member = " + section11Member);
        }
    }

    private void insert() {
        Section11Team teamA = new Section11Team();
        teamA.setName("teamA");
        em.persist(teamA);

        Section11Team teamB = new Section11Team();
        teamB.setName("teamB");
        em.persist(teamB);

        Section11Member member1 = new Section11Member();
        member1.setUsername("user1");
        member1.setTeam(teamA);

        em.persist(member1);

        Section11Member member2 = new Section11Member();
        member2.setUsername("user2");
        member2.setTeam(teamA);

        em.persist(member2);

        Section11Member member3 = new Section11Member();
        member3.setUsername("user2");
        member3.setTeam(teamB);

        em.persist(member3);

        em.flush();
        em.clear();

    }
}

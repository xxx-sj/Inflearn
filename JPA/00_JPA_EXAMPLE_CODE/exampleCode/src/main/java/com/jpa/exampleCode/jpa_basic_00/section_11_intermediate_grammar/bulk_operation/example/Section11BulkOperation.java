package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.bulk_operation.example;

import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Member;
import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class Section11BulkOperation {

    @PersistenceContext
    private EntityManager em;

    public void bulkOperation() {
        this.insert();
        //update 이후 영속성 컨텍스트를 클리어 해주지 않으면
        // update 이전 엔티티가 남아있어 값이 제대로 적용되지 않는다.
        int i = em.createQuery("update Section11Member m set m.age = 20")
                .executeUpdate();

        System.out.println("i = " + i);

        em.clear();


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

package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.use_entity_directly.example;

import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Member;
import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section11UseEntityDirectly {

    @PersistenceContext
    private EntityManager em;


    /**
     * select 절에 식별자가 아닌 ENTITY 그대로 사용하기.
     * 그대로 사용하면 식별자가 사용된다.
     *
     *     select
     *         count(section11m0_.id) as col_0_0_
     *     from
     *         section11member section11m0_
     */
    public void useEntityInSelect() {
        this.insert();

        List<Long> list = em.createQuery("select count(m) from Section11Member as m", Long.class).getResultList();

        for (Long integer : list) {
            System.out.println("integer = " + integer);
        }
    }

    /**
     * query-parameter에 엔티티 사용하기.
     * 위와 동일하게 엔티티 아이디를 사용하게 된다.
     *
     *    select
     *         section11m0_.id as id1_24_,
     *         section11m0_.age as age2_24_,
     *         section11m0_.team_id as team_id5_24_,
     *         section11m0_.type as type3_24_,
     *         section11m0_.username as username4_24_
     *     from
     *         section11member section11m0_
     *     where
     *         section11m0_.id=?
     */
    public void useEntityInQueryParameter() {
        this.insert();

        Section11Member member2 = new Section11Member();
        member2.setUsername("user2");
        em.persist(member2);

        em.flush();
        em.clear();

        Section11Member member = em.createQuery("select m from Section11Member m where m = :member", Section11Member.class)
                .setParameter("member", member2)
                .getSingleResult();

        System.out.println("member = " + member);
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

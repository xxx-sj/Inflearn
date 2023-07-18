package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.path_expression.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Component
@Transactional
public class Section11PathExpression {

    @PersistenceContext
    private EntityManager em;

    /**
     *    select
     *         section10m0_.username as col_0_0_
     *     from
     *         section10member section10m0_
     */
    public void stateFieldQuery() {
        this.insertMember();

        List<String> resultList = em.createQuery("select m.username from Section10Member m", String.class).getResultList();

        for (String section10Member : resultList) {
            System.out.println("section10Member = " + section10Member);
        }
    }

    /**
     *    select
     *         section10t1_.id as id1_23_,
     *         section10t1_.name as name2_23_
     *     from
     *         section10member section10m0_
     *     inner join
     *         section10team section10t1_
     *             on section10m0_.team_id=section10t1_.id
     */
    public void singleRelationQuery() {
        this.insertMember();

        List<Section10Team> resultList = em.createQuery("select m.team from Section10Member m", Section10Team.class).getResultList();
        for (Section10Team section10Team : resultList) {
            System.out.println("section10Team = " + section10Team);
        }
    }

    /**
     *
     *     select
     *         memberlist1_.id as id1_20_,
     *         memberlist1_.age as age2_20_,
     *         memberlist1_.team_id as team_id5_20_,
     *         memberlist1_.type as type3_20_,
     *         memberlist1_.username as username4_20_
     *     from
     *         section10team section10t0_
     *     inner join
     *         section10member memberlist1_
     *             on section10t0_.id=memberlist1_.team_id
     */
    public void collectionQuery() {
        this.insertMember();

        List<Collection> resultList = em.createQuery("select t.memberList from Section10Team t", Collection.class).getResultList();
        for (Collection collection : resultList) {
            System.out.println("collection = " + collection);
        }
    }

    public void explicitJoinQuery () {
        this.insertMember();

        List<String> stringList = em.createQuery("select m.username from Section10Team t join t.memberList m", String.class).getResultList();
        for (String s : stringList) {
            System.out.println("s = " + s);
        }
    }

    private void insertMember() {
        Section10Member member = new Section10Member();
        member.setUsername("member1");
        member.setAge(10);
        member.setType(Section10MemberType.ADMIN);
        em.persist(member);

        em.flush();
        em.clear();
    }
}

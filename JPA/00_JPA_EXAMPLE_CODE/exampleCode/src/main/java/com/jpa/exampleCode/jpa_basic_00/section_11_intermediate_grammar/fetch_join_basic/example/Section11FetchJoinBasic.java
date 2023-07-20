package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.fetch_join_basic.example;

import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Member;
import com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class Section11FetchJoinBasic {

    @PersistenceContext
    private EntityManager em;

    /**
     * 일반적으로 쿼리를 날리게 되면, 1 대 다 관계에서는 N + 1 만큼 쿼리가 나가게 된다.
     * 1 = Member list를 조회하는 쿼리
     * N = member가 속한 team 을 조회하는 쿼리
     * 또, LAZY 로딩으로 설정할 경우 getTeam()은 프록시의 값이 들어오게 되며, Team에서 객체 탐색을 할 떄 쿼리가 나가며, 그 때 값을 불러온다.
     * getTeam().getClass() = class com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team$HibernateProxy$OJtmzVg8
     */
    public void queryBasic() {
        this.insert();

        List<Section11Member> selectMFromSection11Member = em.createQuery("select m from Section11Member m", Section11Member.class).getResultList();
        for (Section11Member section11Member : selectMFromSection11Member) {
            System.out.println("section11Member = " + section11Member.getTeam().getClass());
            System.out.println("section11Member.getUsername() + \", \" + section11Member.getTeam().getName() = " + section11Member.getUsername() + ", " + section11Member.getTeam().getName());
        }
    }

    /**
     * fetch join 을 통해 select을 할 때 join하여 모든 데이터를 가져온다. 기본 inner join
     *
     *     select
     *         section11m0_.id as id1_24_0_,
     *         section11t1_.id as id1_27_1_,
     *         section11m0_.age as age2_24_0_,
     *         section11m0_.team_id as team_id5_24_0_,
     *         section11m0_.type as type3_24_0_,
     *         section11m0_.username as username4_24_0_,
     *         section11t1_.name as name2_27_1_
     *     from
     *         section11member section11m0_
     *     inner join
     *         section11team section11t1_
     *             on section11m0_.team_id=section11t1_.id
     *
     * 위 와는 다르게 getTeam()을 하면 실제 엔티티가 들어온 것을 볼 수 있다.
     * section11Member.getTeam().getClass() = class com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.entity.Section11Team
     */
    public void fetchJoinBasic() {
        this.insert();

        List<Section11Member> selectMFromSection11Member = em.createQuery("select m from Section11Member m join fetch m.team", Section11Member.class).getResultList();
        for (Section11Member section11Member : selectMFromSection11Member) {
            System.out.println("section11Member.getTeam().getClass() = " + section11Member.getTeam().getClass());
            System.out.println("section11Member.getUsername() + \", \" + section11Member.getTeam().getName() = " + section11Member.getUsername() + ", " + section11Member.getTeam().getName());
        }

    }

    public void collectionFetchJoin() {
        this.insert();

        List<Section11Team> resultList = em.createQuery("select t from Section11Team t join fetch t.memberList", Section11Team.class).getResultList();

        for (Section11Team section11Team : resultList) {
            System.out.println("section11Team.getName() + section11Team.getMemberList().size() = " + section11Team.getName() + section11Team.getMemberList().size());
            for (Section11Member section11Member : section11Team.getMemberList()) {
                System.out.println("section11Member = " + section11Member);
            }
        }
    }

    /**
     * distinct
     *  추가로 어플리케이션 레벨에서 중복을 제거해준다.
     */
    public void collectionDistinctFetchJoin() {
        this.insert();

        List<Section11Team> resultList = em.createQuery("select DISTINCT t from Section11Team t join fetch t.memberList", Section11Team.class).getResultList();

        for (Section11Team section11Team : resultList) {
            System.out.println("section11Team.getName() + section11Team.getMemberList().size() = " + section11Team.getName() + section11Team.getMemberList().size());
            for (Section11Member section11Member : section11Team.getMemberList()) {
                System.out.println("section11Member = " + section11Member);
            }
        }
    }

    public void commonJoin() {
        this.insert();


        List<Object[]> list = em.createQuery("select t, m from Section11Team t join t.memberList m", Object[].class).getResultList();

        System.out.println("list.size() = " + list.size());

        for (Object[] objects : list) {
            System.out.println("objects = " + objects[0]);
            System.out.println("objects = " + objects[1]);
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

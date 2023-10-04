package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.feth_join_limit.example;

import com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.entity.Section11Member;
import com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.entity.Section11Team;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section11FetchJoinLimit {

    @PersistenceContext
    private EntityManager em;

    /**
     * 일대 다 fetch join 을 하게되면 다 쪽에row 수 만큼 뻥튀기가 되기 때문에 원하는 결과가 나오지 않고,
     * 페이징을 할 경우
     * HHH000104: firstResult/maxResults specified with collection fetch; applying in memory!
     * 와 같은 WARN을 뱉으며 모든 데이터를 메모리에서 가져와 어플리케이션 레벨에서 페이징을 하게 된다.
     */
    public void fetchJoinPaging() {
        this.insert();

        List<Section11Team> resultList = em.createQuery("select t from Section11Team  t join fetch t.memberList", Section11Team.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

//        em.createQuery("select m from Section11Member m join fetch m.team t");

        for (Section11Team team : resultList) {
            System.out.println("team = " + team);
        }
    }

    /**
     * 일대 다 페치 조인에서 -> 다대 일 페치 조인으로 변경
     */
    public void fetchJoinPagingSolution1() {
        this.insert();

        List<Section11Member> list = em.createQuery("select m from Section11Member m join fetch m.team t", Section11Member.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

    }

    /**
     * 먼저 팀을 페이징만큼 모두 조회한다.
     * LAZY 로딩을 통해 필요할 때 member를 조회해 온다.
     * 대신 성능이 나오지 않는다.
     * +
     * 그래서 추가로 일대다 관계에 batchSize를 넣어서 member에 조회한 team_id를 in절 조건으로 넣어 member를 가져온다.
     * batch_size는 in절에 들어가는 entity_id의 갯수이다.
     *
     * select
     *         memberlist0_.team_id as team_id5_24_1_,
     *         memberlist0_.id as id1_24_1_,
     *         memberlist0_.id as id1_24_0_,
     *         memberlist0_.age as age2_24_0_,
     *         memberlist0_.team_id as team_id5_24_0_,
     *         memberlist0_.type as type3_24_0_,
     *         memberlist0_.username as username4_24_0_
     *     from
     *         section11member memberlist0_
     *     where
     *         memberlist0_.team_id in (
     *             ?, ?
     *         )
     */
    public void fetchJoinPagingSolution() {
        this.insert();

        List<Section11Team> resultList = em.createQuery("select t from Section11Team t", Section11Team.class)
                .setFirstResult(0)
                .setMaxResults(2)
                .getResultList();

        for (Section11Team team : resultList) {
            System.out.println("team = " + team.getName() + "| member" + team.getMemberList());
            for (Section11Member section11Member : team.getMemberList()) {
                System.out.println("section11Member.getUsername() = " + section11Member.getUsername());
            }
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

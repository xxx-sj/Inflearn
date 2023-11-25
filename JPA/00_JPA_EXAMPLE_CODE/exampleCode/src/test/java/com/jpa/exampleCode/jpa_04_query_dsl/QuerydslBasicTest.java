package com.jpa.exampleCode.jpa_04_query_dsl;

import com.jpa.exampleCode.jpa_04_query_dsl.entity.Member;
import com.jpa.exampleCode.jpa_04_query_dsl.entity.QMember;
import com.jpa.exampleCode.jpa_04_query_dsl.entity.Team;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static com.jpa.exampleCode.jpa_04_query_dsl.entity.QMember.member;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);

        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

    }

    @Test
    public void startJPQL (){
        //member1을 찾아라
        List<Member> findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getResultList();

        Assertions.assertEquals(findMember.get(0).getUsername(), "member1");
    }

    @Test
    void startQuerydsl() {
//        QMember m = new QMember("m");
//        QMember m = QMember.member;

        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1")) //파라미터 바인딩
                .fetchOne();

        Assertions.assertEquals(findMember.getUsername(), "member1");
    }

    @Test
    public void search() {
        Member result = queryFactory.selectFrom(member)
                .where(member.username.eq("member1")
                        .and(member.age.between(10, 30))
                )
                .fetchOne();

        Assertions.assertEquals(result.getUsername(), "member1");
    }

    @Test
    public void searchAndParam() {
        Member result = queryFactory.selectFrom(member)
                .where(
                        member.username.eq("member1"),
                        (member.age.eq(10)
                        )
                )
                .fetchOne();

        Assertions.assertEquals(result.getUsername(), "member1");
    }

    @Test
    public void resultFetch() {
//        List<Member> fetch = queryFactory.selectFrom(member)
//                .fetch();
//
//        Member fetchOne = queryFactory.selectFrom(member)
//                .fetchOne();
//
//        Member fetchFirst = queryFactory.selectFrom(member)
//                .fetchFirst();

        //TODO 향후 미지원
        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();


        results.getTotal();
        List<Member> content = results.getResults();

        List<Member> fetchResult = queryFactory
                .selectFrom(member)
                .fetch();

        List<Member> content2 = fetchResult;
        int count = fetchResult.size();

        //TODO 향후 미지원
        long total = queryFactory
                .selectFrom(member)
                .fetchCount();

        Long totalCount = queryFactory.select(member.count())
                .from(member)
                .fetchOne();

    }


    /**
     * 회원 정렬 순서
     * 1. 회원 나이 내림차순
     * 2. 회원이름 올림차순
     * 단 2에서 회원이름이 없으면 마지막에 출력(nulls last)
     */
    @Test
    public void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        List<Member> result = queryFactory.selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull = result.get(2);
        Assertions.assertEquals(member5.getUsername(), "member5");
        Assertions.assertEquals(member6.getUsername(), "member6");
        Assertions.assertNull(memberNull.getUsername());


    }
}

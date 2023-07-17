package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.condition.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class Section10Condition {

    @PersistenceContext
    private EntityManager em;

    public void caseQuery() {
        this.insertMember();

        String query =
                "select " +
                        "case when m.age <= 10 then '학생요금'" +
                        "     when m.age >= 60 then '경로요금'" +
                        "     else '일반요금' " +
                        "end " +
                        "from Section10Member m";
        List resultList = em.createQuery(query).getResultList();
    }

    public void caseSimpleQuery() {
        this.insertMember();

        String query =
                "select " +
                        "case m.age " +
                        "when 10 then '초등학생' " +
                        "when 20 then '성인' " +
                        "else '모름' end " +
                        "from Section10Member m";
        List resultList = em.createQuery(query).getResultList();
    }

    public void coalesceQuery() {
        this.insertMember();

        String query = "select coalesce(m.username, '이름없는 회원') from Section10Member m";
        List<String> list = em.createQuery(query, String.class).getResultList();

        for (String s : list) {
            System.out.println("s = " + s);
        }
    }

    public void nullIfQuery() {
        this.insertMember();

        List<String> list = em.createQuery("select nullif(m.username, '관리자') from Section10Member m", String.class).getResultList();

        for (String s : list) {
            System.out.println("s = " + s);
        }
    }

    private void insertMember() {
        Section10Member member = new Section10Member();
//        member.setUsername("member1");
//        member.setUsername(null);
        member.setUsername("관리자");
        member.setAge(10);
        member.setType(Section10MemberType.ADMIN);
        em.persist(member);

        em.flush();
        em.clear();
    }
}

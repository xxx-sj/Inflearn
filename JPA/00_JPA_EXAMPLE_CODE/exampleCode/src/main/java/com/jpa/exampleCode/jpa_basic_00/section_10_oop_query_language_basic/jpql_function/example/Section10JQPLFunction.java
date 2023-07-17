package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.jpql_function.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section10JQPLFunction {

    @PersistenceContext
    private EntityManager em;

    public void concatQuery() {
//        List<String> resultList = em.createQuery("select concat('a', 'b') from Section10Member  m", String.class).getResultList();
        List<String> resultList1 = em.createQuery("select 'a' || 'b' from Section10Member  m", String.class).getResultList();
    }

    public void substrQuery() {
        List<String> resultList1 = em.createQuery("select substring(m.username, 2, 3) from Section10Member m", String.class).getResultList();
    }

    public void locateQuery() {
        List<Integer> resultList = em.createQuery("select locate('de', 'abcdeqf') from Section10Member  m", Integer.class).getResultList();
    }

    public void userDefFunctionQuery() {
        Section10Member member1 = new Section10Member();
        member1.setUsername("member1");
//        member.setUsername(null);
//        member1.setUsername("관리자");
        member1.setAge(10);
        member1.setType(Section10MemberType.ADMIN);
        em.persist(member1);

        Section10Member member2 = new Section10Member();
        member2.setUsername("member2");
//        member.setUsername(null);
        member2.setUsername("관리자");
        member2.setAge(10);
        member2.setType(Section10MemberType.ADMIN);
        em.persist(member2);

        em.flush();
        em.clear();

//        List<String> resultList = em.createQuery("select function('group_concat', m.username) From Section10Member  m", String.class).getResultList();
        List<String> resultList = em.createQuery("select group_concat(m.username) From Section10Member  m", String.class).getResultList();
        for (String s : resultList) {
            System.out.println("s = " + s);
        }

    }
    private void insertMember() {
        Section10Member member = new Section10Member();
        member.setUsername("member1");
//        member.setUsername(null);
        member.setUsername("관리자");
        member.setAge(10);
        member.setType(Section10MemberType.ADMIN);
        em.persist(member);

        em.flush();
        em.clear();
    }

}

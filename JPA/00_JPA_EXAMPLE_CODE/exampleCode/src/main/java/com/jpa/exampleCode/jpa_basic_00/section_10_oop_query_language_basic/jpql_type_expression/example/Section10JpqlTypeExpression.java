package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.jpql_type_expression.example;

import com.jpa.exampleCode.jpa_basic_00.section_07_advanced_mapping.Inheritance_mapping.entity.Section07Item01;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class Section10JpqlTypeExpression {

    @PersistenceContext
    private EntityManager em;

    public void jqplTypeExpression() {
        this.insertMember();

        List<Object[]> query1 = em.createQuery("select m.username, 'hello',TRUE, 'she''s' from Section10Member m").getResultList();

        for (Object[] objects : query1) {
            System.out.println("objects = " + objects[0]);
            System.out.println("objects = " + objects[1]);
            System.out.println("objects = " + objects[2]);
            System.out.println("objects = " + objects[3]);
        }
    }

    public void jqplEnumType() {
        this.insertMember();

//        List<Object[]> resultList = em.createQuery("select m.username, 'hello' from Section10Member  m " +
//                        "where m.type = com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10MemberType.ADMIN")
//                .getResultList();

        List<Object[]> resultList = em.createQuery("select m.username, 'hello' from Section10Member  m " +
                        "where m.type = :memberType")
                .setParameter("memberType", Section10MemberType.ADMIN)
                .getResultList();

        for (Object[] objects : resultList) {
            System.out.println("objects = " + objects[0]);
            System.out.println("objects = " + objects[1]);
        }

    }

    public void jqplInheritance() {
        List<Section07Item01> item01s = em.createQuery("select i from Section07Item01 i where type(i) = Section07Book01", Section07Item01.class)
                .getResultList();
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

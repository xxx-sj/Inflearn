package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.basic_grammer_and_query_API.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class Section10QueryApi {

    @PersistenceContext
    private final EntityManager em;

    /**
     * TypeQuery: 반환타입이 명확할 때
     */
    public void typeQuery() {
        TypedQuery<Section10Member> query = em.createQuery("select m from Section10Member as m", Section10Member.class);
    }

    /**
     * Query: 반환타입이 명확하지 않을 때
     */
    public void query() {
        Query query = em.createQuery("select m.username, m.age from Section10Member as m");
    }

    /**
     * parameterBinding
     */
    public void parameterBinding() {
        List<Section10Member> resultList = em.createQuery("select m from Section10Member m where m.age > :age", Section10Member.class)
                .setParameter("age", 10)
                .getResultList();

        for (Section10Member section10Member : resultList) {
            System.out.println("section10Member = " + section10Member);
        }

    }
}

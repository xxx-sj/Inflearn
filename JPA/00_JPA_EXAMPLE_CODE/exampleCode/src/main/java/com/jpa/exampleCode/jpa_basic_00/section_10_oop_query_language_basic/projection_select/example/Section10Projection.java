package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.projection_select.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.projection_select.dto.Section10MemberDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section10Projection {

    @PersistenceContext
    private EntityManager em;

    public void projectionQuery() {
        List<Object[]> resultList = em.createQuery("select m.username, m.age from Section10Member m")
                .getResultList();

        Object[] result = resultList.get(0);
        System.out.println("username = " + result[0]);
        System.out.println("age = " + result[1]);
    }

    public void projectionNewOperation() {
        List<Section10MemberDto> result = em.createQuery("select new com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic" +
                        ".projection_select.dto.Section10MemberDto(m.username, m.age) from Section10Member m", Section10MemberDto.class)
                .getResultList();

        Section10MemberDto memberDto = result.get(0);
        System.out.println("memberDto. = " + memberDto.getUsername());
        System.out.println("memberDto.getAge() = " + memberDto.getAge());


    }
}

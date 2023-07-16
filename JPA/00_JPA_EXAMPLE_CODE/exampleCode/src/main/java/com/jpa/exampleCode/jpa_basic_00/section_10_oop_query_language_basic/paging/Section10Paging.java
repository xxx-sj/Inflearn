package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.paging;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity.Section10Member;
import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.projection_select.dto.Section10MemberDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class Section10Paging {

    @PersistenceContext
    private EntityManager em;

    public void paging() {
        for(int i = 0; i < 100; i++) {
            Section10Member member = new Section10Member();
            member.setUsername("member" + i);
            member.setAge(i);
            em.persist(member);
        }

        em.flush();
        em.clear();

        List<Section10MemberDto> resultList = em.createQuery("select m from Section10Member  m order by m.age desc", Section10MemberDto.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();

        for (Section10MemberDto section10MemberDto : resultList) {
            System.out.println("section10MemberDto = " + section10MemberDto);
        }


    }
}

package com.jpa.exampleCode.jpa_basic_00.section_06_various_relation_mapping.many_to_one.example;

import com.jpa.exampleCode.jpa_basic_00.section_06_various_relation_mapping.many_to_one.entity.Section06Member01;
import com.jpa.exampleCode.jpa_basic_00.section_06_various_relation_mapping.many_to_one.entity.Section06Team01;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class Section06ManyToOne {

    @PersistenceContext
    private final EntityManager em;

    public void ManyToOne() {
        Section06Team01 team01 = new Section06Team01();
        team01.setName("team");
        em.persist(team01);
        Section06Member01 member01 = new Section06Member01();
        member01.setUsername("member1");
        member01.setTeam(team01);
        em.persist(member01);

        em.flush();
        em.clear();

        Section06Team01 team011 = em.find(Section06Team01.class, team01.getId());
        List<Section06Member01> members = team011.getMembers();
        System.out.println("=======================");
        for (Section06Member01 member : members) {
            System.out.println("member.getUsername() = " + member.getUsername());
        }
        System.out.println("=======================");

    }

    public void test() {
        Section06Team01 team01 = new Section06Team01();
        team01.setName("team");
        em.persist(team01);
        Section06Member01 member01 = new Section06Member01();
        member01.setUsername("member1");
        member01.setTeam(team01);
        em.persist(member01);

        em.flush();
        em.clear();

        Section06Member01 member011 = em.find(Section06Member01.class, member01.getId());
        System.out.println("member011 = " + member011.getTeam().getClass());
        System.out.println("member011.getTeam().getName() = " + member011.getTeam().getName());

    }
}

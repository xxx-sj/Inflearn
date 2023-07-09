package com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.example;

import com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.entity.Section05Member;
import com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.entity.Section05Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

@Component
@RequiredArgsConstructor
@Transactional
public class Section05Basic {

    @PersistenceContext
    private final EntityManager em;

    public void Section05BasicOwner() {
        Section05Team team = new Section05Team("section05Team");
        em.persist(team);

        Section05Member member = new Section05Member("section05Member");
        member.changeTeam(team);

        em.persist(member);
    }
}

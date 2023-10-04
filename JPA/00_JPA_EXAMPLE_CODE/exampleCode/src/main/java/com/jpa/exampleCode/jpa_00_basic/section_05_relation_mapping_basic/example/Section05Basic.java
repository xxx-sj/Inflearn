package com.jpa.exampleCode.jpa_00_basic.section_05_relation_mapping_basic.example;

import com.jpa.exampleCode.jpa_00_basic.section_05_relation_mapping_basic.entity.Section05Member;
import com.jpa.exampleCode.jpa_00_basic.section_05_relation_mapping_basic.entity.Section05Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    /**
     * 연관관계의 주인이 아닌 Team에 member를 추가해도 저장되지 않는다.
     * member 테이블의 FK값이 null이 들어감
     *
     */
    public void Section05Caution() {
        Section05Member member = new Section05Member("section05Member");
        em.persist(member);

        Section05Team team = new Section05Team("section05Team");
        team.getMemberList().add(member);
        em.persist(team);
    }
}

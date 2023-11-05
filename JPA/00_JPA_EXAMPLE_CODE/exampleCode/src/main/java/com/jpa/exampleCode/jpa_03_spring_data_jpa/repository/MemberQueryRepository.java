package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final EntityManager em;

    List<DataMember> findAllMembers() {
        return em.createQuery("select m from DataMember m", DataMember.class)
                .getResultList();
    }
}

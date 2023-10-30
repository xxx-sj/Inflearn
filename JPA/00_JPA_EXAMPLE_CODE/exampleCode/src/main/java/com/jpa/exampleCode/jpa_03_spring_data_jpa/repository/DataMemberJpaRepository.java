package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.repository.core.EntityMetadata;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DataMemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public DataMember save(DataMember member) {
        em.persist(member);
        return member;
    }

    public DataMember find(Long id) {
        return em.find(DataMember.class, id);
    }
}

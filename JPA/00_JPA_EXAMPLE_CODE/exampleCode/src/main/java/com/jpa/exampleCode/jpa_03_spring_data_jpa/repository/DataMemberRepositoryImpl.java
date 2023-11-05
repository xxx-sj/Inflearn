package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class DataMemberRepositoryImpl implements DataCustomMemberRepository{

    private final EntityManager em;
    @Override
    public List<DataMember> findMemberCustom() {
        return em.createQuery("select m from DataMember m", DataMember.class)
                .getResultList();
    }
}

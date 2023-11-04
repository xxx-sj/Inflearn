package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.springframework.data.repository.core.EntityMetadata;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class DataMemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public DataMember save(DataMember member) {
        em.persist(member);
        return member;
    }

    public void delete(DataMember member) {
        em.remove(member);
    }

    public List<DataMember> findAll() {
        return em.createQuery("select m from DataMember m", DataMember.class)
                .getResultList();
    }

    public Optional<DataMember> findById(Long id) {
        DataMember member = em.find(DataMember.class, id);
        return Optional.ofNullable(member);
    }

    public long count() {
        return em.createQuery("select count(m) from DataMember  m", Long.class)
                .getSingleResult();
    }

    public DataMember find(Long id) {
        return em.find(DataMember.class, id);
    }

    public List<DataMember> findByPage(int age, int offset, int limit) {
        List<DataMember> result = em.createQuery("select m from DataMember m where m.age = :age order by m.username desc", DataMember.class)
                .setParameter("age", age)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        return result;
    }

    public long totalCount(int age) {
        return em.createQuery("select count(m) from DataMember m where m.age = :age", Long.class)
                .setParameter("age", age)
                .getSingleResult();
    }

    public int bulkAgePlus(int age) {
        int resultCount = em.createQuery("update DataMember m set m.age = m.age + 1 where m.age >= :age")
                .setParameter("age", age)
                .executeUpdate();

        return resultCount;
    }
}

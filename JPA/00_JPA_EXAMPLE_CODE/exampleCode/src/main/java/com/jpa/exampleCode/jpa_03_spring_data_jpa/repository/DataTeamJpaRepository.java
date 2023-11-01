package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataTeam;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class DataTeamJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public DataTeam save(DataTeam team) {
        em.persist(team);
        return team;
    }

    public void delete(DataTeam team) {
        em.remove(team);
    }

    public List<DataTeam> findAll() {
        return em.createQuery("select t from DataTeam  t", DataTeam.class)
                .getResultList();
    }

    public Optional<DataTeam> findById(Long id) {
        DataTeam team = em.find(DataTeam.class, id);
        return Optional.ofNullable(team);
    }

    public long count() {
        return em.createQuery("select count(t) from DataTeam  t", Long.class)
                .getSingleResult();
    }
}

package com.jpa.exampleCode.jpa_00_basic.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan;

import com.jpa.exampleCode.jpa_00_basic.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan.entity.Section08Child;
import com.jpa.exampleCode.jpa_00_basic.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan.entity.Section08Parent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class Section08CasCadeAndOrphan {

    @PersistenceContext
    private EntityManager em;

    public void beforeUsingCasCade() {
        Section08Child child1 = new Section08Child();
        Section08Child child2 = new Section08Child();

        Section08Parent parent = new Section08Parent();
        parent.addChild(child1);
        parent.addChild(child2);

        em.persist(child1);
        em.persist(child2);
        em.persist(parent);
    }

    /**
     * parent의 childList에 CASCADETYPE.ALL 추가
     */
    public void afterUsingCasCade() {
        Section08Child child1 = new Section08Child();
        Section08Child child2 = new Section08Child();

        Section08Parent parent = new Section08Parent();
        parent.addChild(child1);
        parent.addChild(child2);

        em.persist(parent);
    }

    public void orphanRemoval() {
        Section08Child child1 = new Section08Child();
        Section08Child child2 = new Section08Child();

        Section08Parent parent = new Section08Parent();
        parent.addChild(child1);
        parent.addChild(child2);

        em.persist(parent);

        em.flush();
        em.clear();

        Section08Parent parent1 = em.find(Section08Parent.class, parent.getId());
        parent1.getChildList().remove(0);
    }
}

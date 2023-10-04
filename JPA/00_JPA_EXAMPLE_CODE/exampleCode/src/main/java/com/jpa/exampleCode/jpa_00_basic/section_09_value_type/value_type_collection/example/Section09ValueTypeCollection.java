package com.jpa.exampleCode.jpa_00_basic.section_09_value_type.value_type_collection.example;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class Section09ValueTypeCollection {

    @PersistenceContext
    private EntityManager em;




}

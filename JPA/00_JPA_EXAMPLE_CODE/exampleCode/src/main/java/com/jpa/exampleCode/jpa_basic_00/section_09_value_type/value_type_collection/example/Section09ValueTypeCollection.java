package com.jpa.exampleCode.jpa_basic_00.section_09_value_type.value_type_collection.example;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

@Component
@Transactional
public class Section09ValueTypeCollection {

    @PersistenceContext
    private EntityManager em;




}

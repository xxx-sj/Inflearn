package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.condition.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Section10ConditionTest {

    @Autowired
    Section10Condition service;

    @Test
    void caseQuery() {
        service.caseQuery();
    }

    @Test
    void caseSimpleQueryTest() {
        service.caseSimpleQuery();
    }

    @Test
    void coalesceQueryTest() {
        service.coalesceQuery();
    }

    @Test
    void nullIfQueryTest() {
        service.nullIfQuery();
    }

}
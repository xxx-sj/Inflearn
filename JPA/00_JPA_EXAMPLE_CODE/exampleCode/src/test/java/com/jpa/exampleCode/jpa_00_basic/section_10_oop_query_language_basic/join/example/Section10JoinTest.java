package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.join.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section10JoinTest {

    @Autowired
    Section10Join service;

    @Test
    void innerJoin() {
        service.innerJoin();
    }

    @Test
    void outerJoin() {
        service.leftOuterJoin();
    }

    @Test
    void thetaJoin() {
        service.thetaJoin();
    }

    @Test
    void onJoin() {
        service.onJoin();
    }

    @Test
    void nonRelationJoin() {
        service.nonRelationJoin();
    }

}
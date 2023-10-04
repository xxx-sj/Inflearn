package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.jpql_function.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section10JQPLFunctionTest {

    @Autowired
    Section10JQPLFunction service;

    @Test
    void concatQuery() {
    }

    @Test
    void substrQuery() {
    }

    @Test
    void locateQuery() {
    }

    @Test
    void userDefFunctionQuery() {
        service.userDefFunctionQuery();
    }
}
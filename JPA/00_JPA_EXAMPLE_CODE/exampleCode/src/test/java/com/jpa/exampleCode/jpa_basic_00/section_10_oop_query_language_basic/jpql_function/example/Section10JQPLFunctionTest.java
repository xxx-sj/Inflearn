package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.jpql_function.example;

import com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.jpql_function.dialect.Section10MyH2Dialect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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
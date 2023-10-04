package com.jpa.exampleCode.jpa_00_basic.section_10_oop_query_language_basic.jpql_type_expression.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class Section10JpqlTypeExpressionTest {

    @Autowired
    Section10JpqlTypeExpression service;

    @Test
    void jqplTypeExpressionTest() {
        service.jqplTypeExpression();
    }

    @Test
    void jqplEnumTypeTest() {
        service.jqplEnumType();
    }

    @Test
    void jqplInheritanceTest() {
        service.jqplInheritance();
    }
}
package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.path_expression.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Section11PathExpressionTest {

    @Autowired
    Section11PathExpression service;

    @Test
    void stateFieldQuery() {

        service.stateFieldQuery();
    }

    @Test
    void singleRelationQuery() {
        service.singleRelationQuery();
    }

    @Test
    void collectionQuery() {
        service.collectionQuery();
    }

    @Test
    void explicitJoinQuery() {
        service.explicitJoinQuery();
    }
}
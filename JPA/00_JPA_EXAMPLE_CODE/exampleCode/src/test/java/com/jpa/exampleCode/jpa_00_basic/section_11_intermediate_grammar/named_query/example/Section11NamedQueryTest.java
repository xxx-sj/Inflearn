package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.named_query.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section11NamedQueryTest {

    @Autowired
    Section11NamedQuery service;
    @Test
    void namedQuery() {
        service.namedQuery();
    }
}
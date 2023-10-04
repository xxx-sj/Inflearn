package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.use_entity_directly.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section11UseEntityDirectlyTest {


    @Autowired
    Section11UseEntityDirectly service;

    @Test
    void useEntityInSelect() {

        service.useEntityInSelect();
    }

    @Test
    void useEntityInQueryParameter() {
        service.useEntityInQueryParameter();
    }

    @Test
    void useEntityInWhere() {
        service.useEntityInWhere();
    }
}
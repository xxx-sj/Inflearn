package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.use_entity_directly.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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
}
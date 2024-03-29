package com.jpa.exampleCode.jpa_00_basic.section_06_various_relation_mapping.many_to_one.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section06ManyToOneTest {

    @Autowired
    Section06ManyToOne section06ManyToOne;

    @Test
    void ManyToOne() {
        section06ManyToOne.ManyToOne();
    }

    @Test
    void testMethod() {
        section06ManyToOne.test();
    }
}
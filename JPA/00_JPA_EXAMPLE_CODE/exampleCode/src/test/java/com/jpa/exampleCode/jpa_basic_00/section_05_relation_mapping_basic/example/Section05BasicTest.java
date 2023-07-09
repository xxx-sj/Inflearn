package com.jpa.exampleCode.jpa_basic_00.section_05_relation_mapping_basic.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class Section05BasicTest {

    @Autowired
    Section05Basic section05Basic;

    @Test
    void Section05BasicOwnerTest() {
        section05Basic.Section05BasicOwner();
    }

}
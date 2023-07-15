package com.jpa.exampleCode.jpa_basic_00.section_08_proxy_and_managed_relation_mapping.cascasd_and_orphan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class Section08CasCadeAndOrphanTest {

    @Autowired
    Section08CasCadeAndOrphan service;

    @Test
    void beforeCascade() {
        service.beforeUsingCasCade();
    }

    @Test
    void afterCascade() {
        service.afterUsingCasCade();
    }

    @Test
    void orphanRemovalTest() {
        service.orphanRemoval();
    }
}
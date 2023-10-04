package com.jpa.exampleCode.jpa_00_basic.section_05_relation_mapping_basic.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    @DisplayName("연관관계 주인이 아닌 엔티티에서 저장하면 FK값이 null이 들어간다.")
    void Section05CautionTest() {
        section05Basic.Section05Caution();
    }

}
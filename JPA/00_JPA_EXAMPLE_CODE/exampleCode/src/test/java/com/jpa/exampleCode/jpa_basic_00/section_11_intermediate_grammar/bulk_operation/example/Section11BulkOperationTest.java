package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.bulk_operation.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Section11BulkOperationTest {

    @Autowired
    Section11BulkOperation service;

    @Test
    void bulkOperation() {
        service.bulkOperation();
    }

}
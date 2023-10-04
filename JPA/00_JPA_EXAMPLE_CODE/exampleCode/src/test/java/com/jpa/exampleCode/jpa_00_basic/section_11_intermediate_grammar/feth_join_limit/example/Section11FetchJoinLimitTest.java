package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.feth_join_limit.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class Section11FetchJoinLimitTest {

    @Autowired
    Section11FetchJoinLimit service;
    @Test
    void fetchJoinPaging() {
        service.fetchJoinPaging();
    }

    @Test
    void fetchJoinPagingSolution() {
        service.fetchJoinPagingSolution();
    }
}
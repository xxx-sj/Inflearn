package com.jpa.exampleCode.jpa_basic_00.section_11_intermediate_grammar.fetch_join_basic.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Section11FetchJoinBasicTest {

    @Autowired
    Section11FetchJoinBasic service;

    @Test
    void queryBasic() {
        service.queryBasic();
    }
    @Test
    void fetchJoinBasic() {
        service.fetchJoinBasic();
    }

    @Test
    void collectionFetchJoin() {
        service.collectionFetchJoin();
    }

    @Test
    void commonJoin() {
        service.commonJoin();
    }
}
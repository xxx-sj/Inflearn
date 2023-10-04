package com.jpa.exampleCode.jpa_00_basic.section_11_intermediate_grammar.fetch_join_basic.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
//@Transactional
@Rollback(value = false)
class Section11FetchJoinBasicTest {

    @Autowired
    Section11FetchJoinBasic service;

    @Test
    void queryBasic() {
        service.queryBasic();
    }

    @Test
    void queryTest() {
        service.queryTest();
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
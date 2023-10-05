package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class Section04SearchWithDtoTest {

    @Autowired
    Section04SearchWithDto section04SearchWithDto;

    @Test
    @DisplayName("collection dto 조회")
    void selectWithCollectionDto() {
        section04SearchWithDto.ordersV4();
    }

}
package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.plat_data_opt;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.collection_search_opt_07_v5.Section04PlatDataOpt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class Section04PlatDataOptTest {

    Section04PlatDataOpt section04PlatDataOpt;


    @Test
    @DisplayName("컬렉션 조회 최적화")
    void select_collection_opt() {
        section04PlatDataOpt.ordersV5();
    }

}
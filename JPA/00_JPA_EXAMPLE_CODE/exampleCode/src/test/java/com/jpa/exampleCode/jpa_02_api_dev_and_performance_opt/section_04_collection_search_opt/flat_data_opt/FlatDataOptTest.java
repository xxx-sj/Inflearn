package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.flat_data_opt;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.flat_data_opt_v6.FlatDataOpt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class FlatDataOptTest {

    @Autowired
    FlatDataOpt flatDataOpt;

    @Test
    void ordersV6Test() {
        flatDataOpt.findAllByDto_flat();
    }

}
package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.flat_data_opt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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
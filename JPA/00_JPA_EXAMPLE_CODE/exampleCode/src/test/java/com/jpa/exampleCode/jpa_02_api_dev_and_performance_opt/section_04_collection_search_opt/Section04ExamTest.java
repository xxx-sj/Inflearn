package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.entityToDTO_paging_04.Section04Exam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false)
class Section04ExamTest {

    @Autowired
    Section04Exam section04Exam;

    @Test
    @DisplayName("컬렉션 페치조인 최적화, 페이징 한계 돌파")
    void collectionFetchJoinOpt() {
        section04Exam.findAllWithMemberDelivery();
    }


    @Test
    @DisplayName("컬렉션 페치조인 최적화, 페이징 한계 돌파")
    void collectionFetchJoinOpt2() {
        section04Exam.findAllWithMemberDelivery(1, 100);
    }
}


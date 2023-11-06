package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataItemRepositoryTest {

    @Autowired DataItemRepository dataItemRepository;

    @Test
    public void save() {
        DataItem item = new DataItem("A");
        dataItemRepository.save(item);
    }
}
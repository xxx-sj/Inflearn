package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    DataMemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        DataMember member=  new DataMember("memberA");
        DataMember savedMember = memberJpaRepository.save(member);

        DataMember findMember = memberJpaRepository.find(savedMember.getId());

        Assertions.assertEquals(findMember.getId(), member.getId());
        Assertions.assertEquals(findMember, member);
    }
}
package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class DataMemberJpaRepositoryTest {

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

    @Test
    public void basicCRUD() {
        DataMember member1 = new DataMember("member1");
        DataMember member2 = new DataMember("member2");

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        DataMember findMember1 = memberJpaRepository.findById(member1.getId()).get();
        DataMember findMember2 = memberJpaRepository.findById(member2.getId()).get();

        Assertions.assertEquals(findMember1, member1);
        Assertions.assertEquals(findMember2, member2);

        //리스트 검증
        List<DataMember> all = memberJpaRepository.findAll();
        Assertions.assertEquals(all.size(), 2);

        long count = memberJpaRepository.count();
        Assertions.assertEquals(count, 2);

        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        long count2 = memberJpaRepository.count();
        Assertions.assertEquals(count2, 0);
    }


    @Test
    public void paging() {
        memberJpaRepository.save(new DataMember("member1", 10));
        memberJpaRepository.save(new DataMember("member2", 10));
        memberJpaRepository.save(new DataMember("member3", 10));
        memberJpaRepository.save(new DataMember("member4", 10));
        memberJpaRepository.save(new DataMember("member5", 10));
        memberJpaRepository.save(new DataMember("member6", 10));

        int age = 10;
        int offset = 0;
        int limit = 3;
        //when
        List<DataMember> members = memberJpaRepository.findByPage(age, offset, limit);
        long totalCount = memberJpaRepository.totalCount(age);

        //페이지 계산 공식 적용
        // totalPage = totalCount / size
        //마지막 페이지
        //최초 페이지

        //then
        Assertions.assertEquals(members.size(), 3);
        Assertions.assertEquals(totalCount, 6);
    }
}
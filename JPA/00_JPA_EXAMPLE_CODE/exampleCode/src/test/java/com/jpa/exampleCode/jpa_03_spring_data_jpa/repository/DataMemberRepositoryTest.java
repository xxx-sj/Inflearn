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
class DataMemberRepositoryTest {

    @Autowired
    DataMemberRepository memberRepository;

    @Test
    public void testMember() {
        DataMember member = new DataMember("memberA");
        DataMember save = memberRepository.save(member);
        DataMember findMember = memberRepository.findById(save.getId()).get();

        Assertions.assertEquals(findMember.getId(), member.getId());
        Assertions.assertEquals(findMember.getUsername(), member.getUsername());
    }

    @Test
    public void basicCRUD() {
        DataMember member1 = new DataMember("member1");
        DataMember member2 = new DataMember("member2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        DataMember findMember1 = memberRepository.findById(member1.getId()).get();
        DataMember findMember2 = memberRepository.findById(member2.getId()).get();

        Assertions.assertEquals(findMember1, member1);
        Assertions.assertEquals(findMember2, member2);

        //리스트 검증
        List<DataMember> all = memberRepository.findAll();
        Assertions.assertEquals(all.size(), 2);

        long count = memberRepository.count();
        Assertions.assertEquals(count, 2);

        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long count2 = memberRepository.count();
        Assertions.assertEquals(count2, 0);
    }

    @Test
    void findByUsername() {
        DataMember member1 = new DataMember("member1");
        DataMember member2 = new DataMember("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<DataMember> member11 = memberRepository.findByUsername("member1");

        Assertions.assertEquals(member11.get(0).getUsername(), member1.getUsername());
    }

    @Test
    public void test() {
        DataMember m1 = new DataMember("AAA", 10);
        DataMember m2 = new DataMember("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<DataMember> result = memberRepository.findUser("AAA", 10);
        Assertions.assertEquals(result.get(0), m1);
    }

}
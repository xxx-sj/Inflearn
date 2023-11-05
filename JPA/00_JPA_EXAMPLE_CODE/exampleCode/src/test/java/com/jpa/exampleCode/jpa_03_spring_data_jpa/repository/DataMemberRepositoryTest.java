package com.jpa.exampleCode.jpa_03_spring_data_jpa.repository;

import com.jpa.exampleCode.jpa_03_spring_data_jpa.dto.DataMemberDto;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataMember;
import com.jpa.exampleCode.jpa_03_spring_data_jpa.entity.DataTeam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class DataMemberRepositoryTest {

    @Autowired
    DataMemberRepository memberRepository;

    @Autowired
    DataTeamRepository teamRepository;
    @Autowired
    EntityManager em;

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
    public void testQuery() {
        DataMember m1 = new DataMember("AAA", 10);
        DataMember m2 = new DataMember("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<DataMember> result = memberRepository.findUser("AAA", 10);
        Assertions.assertEquals(result.get(0), m1);
    }

    @Test
    public void findUsernameList() {
        DataMember m1 = new DataMember("AAA", 10);
        DataMember m2 = new DataMember("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> stringList = memberRepository.findUSernameList();
        for (String s : stringList) {
            System.out.println("s = " + s);
        }

    }

    @Test
    public void findMemberDto() {
        DataTeam team = new DataTeam("teamA");
        teamRepository.save(team);

        DataMember m1 = new DataMember("AAA", 10);
        m1.changeTeam(team);

        memberRepository.save(m1);

        List<DataMemberDto> memberDto = memberRepository.findMemberDto();
        for (DataMemberDto dataMemberDto : memberDto) {
            System.out.println("dataMemberDto = " + dataMemberDto);
        }

    }

    @Test
    public void findByNames() {
        DataMember m1 = new DataMember("AAA", 10);
        DataMember m2 = new DataMember("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<DataMember> byNames = memberRepository.findByNames(Arrays.asList("aaa", "BBb"));
        for (DataMember byName : byNames) {
            System.out.println("byName = " + byName);
        }

    }

    @Test
    public void returnType() {
        DataMember m1 = new DataMember("AAA", 10);
        DataMember m2 = new DataMember("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<DataMember> aaa = memberRepository.findListByUsername("AAA");
        for (DataMember member : aaa) {
            System.out.println("member = " + member);
        }

        DataMember aaa1 = memberRepository.findMemberByUsername("AAA");
        System.out.println("aaa1 = " + aaa1);

        Optional<DataMember> aaa2 = memberRepository.findOptionalByUsername("AAA");
        System.out.println("aaa2.get() = " + aaa2.get());

    }

    //dto로 변환해서 반환하기
    @Test
    public void paging() {
        memberRepository.save(new DataMember("member1", 10));
        memberRepository.save(new DataMember("member2", 10));
        memberRepository.save(new DataMember("member3", 10));
        memberRepository.save(new DataMember("member4", 10));
        memberRepository.save(new DataMember("member5", 10));
        memberRepository.save(new DataMember("member6", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
        //when
        Page<DataMember> page = memberRepository.findByAge(age, pageRequest);
        
        Page<DataMemberDto> toMap = page.map(member -> new DataMemberDto(member.getId(), member.getUsername(), null));
        
        List<DataMember> content = page.getContent();
        long totalElements = page.getTotalElements();

        for (DataMember member : content) {
            System.out.println("member = " + member);
        }
        System.out.println("totalElements = " + totalElements);

        System.out.println("page.getNumber() = " + page.getNumber());
        Assertions.assertEquals(content.size(), 3);
        Assertions.assertEquals(page.getTotalElements(), 6);
        Assertions.assertEquals(page.getNumber(), 0);
        Assertions.assertEquals(page.getTotalPages(), 2);
        Assertions.assertTrue(page.isFirst());
        Assertions.assertTrue(page.hasNext());
        
    }

    //slice는 limit + 1을 통해 다음 페이지가 있는지 확인한다. size = 3 => 4를 요청
    //반환타입을 slice로 해주어야 한다.
    @Test
    public void paging2() {
        memberRepository.save(new DataMember("member1", 10));
        memberRepository.save(new DataMember("member2", 10));
        memberRepository.save(new DataMember("member3", 10));
        memberRepository.save(new DataMember("member4", 10));
        memberRepository.save(new DataMember("member5", 10));
        memberRepository.save(new DataMember("member6", 10));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));
        //when
        Slice<DataMember> page = memberRepository.findUserSliceByAge(age, pageRequest);

        List<DataMember> content = page.getContent();
//        long totalElements = page.getTotalElements();

        for (DataMember member : content) {
            System.out.println("member = " + member);
        }
//        System.out.println("totalElements = " + totalElements);

        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getNumberOfElements() = " + page.getNumberOfElements());
        System.out.println("page.getNumber() = " + page.getNumber());
        Assertions.assertEquals(content.size(), 3);
//        Assertions.assertEquals(page.getTotalElements(), 6);
        Assertions.assertEquals(page.getNumber(), 0);
//        Assertions.assertEquals(page.getTotalPages(), 2);
        Assertions.assertTrue(page.isFirst());
        Assertions.assertTrue(page.hasNext());

    }

    @Test
    public void bulkUpdate() {
        memberRepository.save(new DataMember("member1", 10));
        memberRepository.save(new DataMember("member2", 19));
        memberRepository.save(new DataMember("member3", 20));
        memberRepository.save(new DataMember("member4", 21));
        memberRepository.save(new DataMember("member5", 40));


        List<DataMember> member1 = memberRepository.findByUsername("member1");
        DataMember member = member1.get(0);
        member.setAge(15);

        int resultCount = memberRepository.bulkAgePlus(20);

//        em.flush();
//        em.clear();
        List<DataMember> result = memberRepository.findByUsername("member5");
        DataMember member5 = result.get(0);
        System.out.println("member5.getAge() = " + member5.getAge());
        Assertions.assertEquals(resultCount, 3);
    }


    @Test
    public void findMemberLazy() {
        //given


        DataTeam teamA = new DataTeam("teamA");
        DataTeam teamB = new DataTeam("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        DataMember member1 = new DataMember("member1", 10, teamA);
        DataMember member2 = new DataMember("member2", 10, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

//        List<DataMember> members = memberRepository.findAll();
//        List<DataMember> members = memberRepository.findMemberEntityGraph();
        List<DataMember> members = memberRepository.findMemberEntityGraph();
//        List<DataMember> members = memberRepository.findMemberFetchJoin();

        for (DataMember member : members) {
            System.out.println("member = " + member);
            System.out.println(member.getTeam().getClass());
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
            System.out.println(member.getTeam().getClass());

        }
    }

    @Test
    public void queryHint() {
        DataMember member1 = memberRepository.save(new DataMember("member1", 10));
        em.flush();
        em.clear();

        DataMember findMember = memberRepository.findReadOnlyByUsername("member1");
        findMember.setUsername("member2");
        em.flush();

    }

    @Test
    public void lock() {
        DataMember member1 = memberRepository.save(new DataMember("member1", 10));
        em.flush();
        em.clear();

        List<DataMember> member11 = memberRepository.findLockByUsername("member1");
//        findMember.setUsername("member2");
        em.flush();

    }

    @Test
    public void callTest() {
        memberRepository.findMemberCustom();
    }


}
package study.querydsl.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired MemberRepository memberRepository;

    @Test
    public void basicTest() {
        Member member = new Member("member1", 10);
        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(findMember).isEqualTo(member);

//        List<Member> result1 = memberJpaRepository.findAll();
        List<Member> result1 = memberRepository.findAll();
        Assertions.assertThat(result1).containsExactly(member);

//        List<Member> result2 = memberJpaRepository.findByUsername("member1");
        List<Member> result2 = memberRepository.findByUsername("member1");
        Assertions.assertThat(result2).containsExactly(member);
    }
}

package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member save = memberRepository.save(member);

        Member findMember = memberRepository.findById(save.getId());

        Assertions.assertThat(findMember).isEqualTo(save);
    }

    @Test
    void findALl() {
        Member member = new Member("member1", 20);
        Member member1 = new Member("member2", 21);

        memberRepository.save(member);
        memberRepository.save(member1);

        List<Member> findAllMembers = memberRepository.findAll();

        Assertions.assertThat(findAllMembers.size()).isEqualTo(2);
        Assertions.assertThat(findAllMembers).contains(member, member1);
    }
}
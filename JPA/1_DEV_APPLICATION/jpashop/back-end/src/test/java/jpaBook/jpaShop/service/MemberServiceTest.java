package jpaBook.jpaShop.service;

import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Fail.fail;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepository;

    @Test
    public void  회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when 
        Long savedId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }
    
    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        //when 
        memberService.join(member1);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//        Assertions.fail("예외가 발생해야 합니다.");
    }
}
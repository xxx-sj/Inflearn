package jpaBook.jpaShop.service;

import jpaBook.jpaShop.controller.member.dto.MemberListResponseDto;
import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.repository.MemberRepository;
import jpaBook.jpaShop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회웝입니다.");
        }
    }

    //전체 회원 조회
    public List<MemberListResponseDto> findMembers() {
        return memberRepository.findAll().stream()
                .map(member -> new MemberListResponseDto(member))
                .collect(Collectors.toList());
    }

    public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
        return memberRepository.findById(memberId).get();
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get();
        member.setName(name);
    }
}

package jpaBook.jpaShop.api;

import jpaBook.jpaShop.controller.member.dto.MemberListResponseDto;
import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v1/members")
    public List<MemberListResponseDto> membersV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result memberV2() {
        List<MemberListResponseDto> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponseDto updateMemberV2(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateMemberRequestDto requestDto) {

        memberService.update(id, requestDto.getName());
        Member findMember = memberService.findOne(id);
        return new UpdateMemberResponseDto(findMember.getId(), findMember.getName());

    }

    @Data
    static class UpdateMemberRequestDto {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponseDto {
        private Long id;
        private String name;
    }

    @Data
    static class CreateMemberRequest{
        private String name;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}

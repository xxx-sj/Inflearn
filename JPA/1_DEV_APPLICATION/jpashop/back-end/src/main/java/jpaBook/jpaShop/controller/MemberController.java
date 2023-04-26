package jpaBook.jpaShop.controller;

import jpaBook.jpaShop.domain.Address;
import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("rest/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public void create(@Valid @RequestBody MemberForm form) {

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
    }

    @GetMapping("/member")
    @ResponseBody
    public Member find() {

        return new Member();
    }
}

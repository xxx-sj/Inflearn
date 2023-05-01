package jpaBook.jpaShop.controller.member;

import jpaBook.jpaShop.controller.member.dto.MemberForm;
import jpaBook.jpaShop.domain.Address;
import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rest/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public void create(@Valid @RequestBody MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("aaa");
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
    }

    @GetMapping("/members")
    public List<Member> list() {
        return memberService.findMembers();
    }
}

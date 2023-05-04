package jpaBook.jpaShop.controller.member.dto;

import jpaBook.jpaShop.domain.Address;
import jpaBook.jpaShop.domain.Member;
import lombok.Getter;

@Getter
public class MemberListResponseDto {

    private Long id;
    private String name;
    private Address address;

    public MemberListResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.address = member.getAddress();
    }
}

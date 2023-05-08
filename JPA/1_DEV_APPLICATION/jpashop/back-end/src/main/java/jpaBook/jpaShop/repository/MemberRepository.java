package jpaBook.jpaShop.repository;

import jpaBook.jpaShop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // findBy*
    // select m from Member m where m.name = ?
    List<Member> findByName(String name);
}

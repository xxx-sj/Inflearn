package jpaBook.jpaShop;

import jpaBook.jpaShop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    //entity manager 주입
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);

        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}

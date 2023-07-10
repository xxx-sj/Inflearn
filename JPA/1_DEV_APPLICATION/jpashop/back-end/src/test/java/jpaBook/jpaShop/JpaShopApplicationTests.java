package jpaBook.jpaShop;

import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
class JpaShopApplicationTests {

	@PersistenceContext
	EntityManager em;
	@Test
	void contextLoads() {
	}

	@Test
	void testCode() {

		Team team = new Team();
		team.setName("TeamA");
		em.persist(team);




		Member member = new Member();
		member.setName("member1");
		member.setTeam(team);
		em.persist(member);


//		em.flush();
//		em.clear();
		team.getMemberList().add(member);

		Team findTeam = em.find(Team.class, team.getId());
		List<Member> memberList = findTeam.getMemberList();
		System.out.println("memberList = " + memberList.size());
		for (Member member1 : memberList) {
			System.out.println("member1.getName() = " + member1.getName());
		}
	}


}

package jpaBook.jpaShop.repository;

import jpaBook.jpaShop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.core.EntityMetadata;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    //저장
    public void save(Item item) {
        if (item.getId() == null) {
            //새로 생성한 객체 / 신규 등록
            em.persist(item);
        } else {
            //디비에 등록된 값을 영속성 컨텍스트에 넣은 상황
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}

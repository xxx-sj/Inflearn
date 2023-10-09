package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.entityToDTO_paging_04_v3;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.Jpa2Order;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.Jpa2OrderItem;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class Section04Exam {

    @PersistenceContext
    private EntityManager em;


    public void findAllWithMemberDelivery() {

        List<Jpa2Order> orders = em.createQuery("select o from Jpa2Order o" +
                " join fetch o.member m" +
                " join fetch o.delivery d", Jpa2Order.class
        ).getResultList();

        orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
    }

    /**
     * offset, limit을 설정하면 기본적으로 jpql에서 조회하는 데이터들이 페이징된다.
     * @param offset
     * @param limit
     */
    public void findAllWithMemberDelivery(int offset, int limit) {

        List<Jpa2Order> orders = em.createQuery("select o from Jpa2Order o" +
                " join fetch o.member m" +
                " join fetch o.delivery d", Jpa2Order.class
        )
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
    }

    @Getter
    static class OrderDto {

        public OrderDto(Jpa2Order order) {
            order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    static class OrderItemDto {
        public OrderItemDto(Jpa2OrderItem orderItem) {
            orderItem.getItem().getName();
        }
    }

}

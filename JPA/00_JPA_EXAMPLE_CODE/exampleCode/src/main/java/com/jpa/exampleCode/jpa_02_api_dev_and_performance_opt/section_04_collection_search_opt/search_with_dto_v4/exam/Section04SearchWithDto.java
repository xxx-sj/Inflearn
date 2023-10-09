package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto_v4.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Section04SearchWithDto {

    private final EntityManager em;

    public List<OrderQueryDto> ordersV4() {
        List<OrderQueryDto> result = findOrders(); // 쿼리 1번 -> item (N)2개 추가조회

        result.forEach(o -> {
            List<OrderItemQueryDto> orderItems = findOrderItems(o.getOrderId());
            o.setOrderItems(orderItems);
        });

        return result;
    }

    private List<OrderItemQueryDto> findOrderItems(Long orderId) {
        return em.createQuery(
                "select new com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt" +
                        ".section_04_collection_search_opt.search_with_dto.exam" +
                        ".OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count)" +
                        " from Jpa2OrderItem oi" +
                        " join oi.item i" +
                        " where oi.order.id = :orderId", OrderItemQueryDto.class
        )
                .setParameter("orderId", orderId)
                .getResultList();
    }

    private List<OrderQueryDto> findOrders() {
        return em.createQuery(
                "select new com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt" +
                        ".section_04_collection_search_opt.search_with_dto.exam" +
                        ".OrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " from Jpa2Order o" +
                    " join o.member m" +
                    " join o.delivery d", OrderQueryDto.class

        ).getResultList();
    }


}

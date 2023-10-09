package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.collection_search_opt_07_v5;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto_v4.exam.OrderItemQueryDto;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto_v4.exam.OrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Section04PlatDataOpt {

    private final EntityManager em;

    public List<OrderQueryDto> ordersV5() {
        return findAllByDto_optimization();
    }

    public List<OrderQueryDto> findAllByDto_optimization() {
        List<OrderQueryDto> result = findOrders();

        List<Long> orderIds = toOrderIds(result);


        Map<Long, List<OrderItemQueryDto>> orderItemMap = findOrderItemMap(orderIds);

        result.forEach(o -> o.setOrderItems(orderItemMap.get(o.getOrderId())));

        return result;
    }

    private Map<Long, List<OrderItemQueryDto>> findOrderItemMap(List<Long> orderIds) {
        List<OrderItemQueryDto> orderItems = em.createQuery(
                        "select new com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt" +
                                ".section_04_collection_search_opt.search_with_dto.exam" +
                                ".OrderItemQueryDto(oi.order.id, i.name, oi.orderPrice, oi.count)" +
                                " from Jpa2OrderItem oi" +
                                " join oi.item i" +
                                " where oi.order.id in :orderIds", OrderItemQueryDto.class
                )
                .setParameter("orderIds", orderIds)
                .getResultList();

        Map<Long, List<OrderItemQueryDto>> orderItemMap = orderItems.stream()
                .collect(Collectors.groupingBy(orderItemQueryDto -> orderItemQueryDto.getOrderId()));
        return orderItemMap;
    }

    private static List<Long> toOrderIds(List<OrderQueryDto> result) {
        List<Long> orderIds = result.stream()
                .map(o -> o.getOrderId())
                .collect(Collectors.toList());
        return orderIds;
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

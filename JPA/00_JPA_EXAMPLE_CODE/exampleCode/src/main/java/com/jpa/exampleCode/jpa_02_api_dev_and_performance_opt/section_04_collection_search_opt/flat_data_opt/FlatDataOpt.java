package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.flat_data_opt;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto.exam.OrderItemQueryDto;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.search_with_dto.exam.OrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class FlatDataOpt {

    private final EntityManager em;


    public List<OrderQueryDto> ordersV6() {

        List<OrderFlatDto> flats = findAllByDto_flat();

        return flats.stream()
                .collect(
                        Collectors.groupingBy(o -> new OrderQueryDto(o.getOrderId(), o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
                                Collectors.mapping(o -> new OrderItemQueryDto(o.getOrderId(), o.getItemName(), o.getOrderPrice(), o.getCount()), Collectors.toList())
                )).entrySet().stream()
                .map(e -> new OrderQueryDto(e.getKey().getOrderId(), e.getKey().getName(), e.getKey().getOrderDate(), e.getKey().getOrderStatus(), e.getKey().getAddress(), e.getValue()))
                .collect(Collectors.toList());

    }
    public List<OrderFlatDto> findAllByDto_flat() {
        return em.createQuery(
                "select new com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt" +
                        ".section_04_collection_search_opt.flat_data_opt" +
                        ".OrderFlatDto(o.id, m.name, o.orderDate, o.status, d.address, i.name, oi.orderPrice, oi.count)" +
                        " from Jpa2Order o" +
                        " join o.member m" +
                        " join o.delivery d" +
                        " join o.orderItems oi" +
                        " join oi.item i", OrderFlatDto.class
        )
                .getResultList();
    }
}

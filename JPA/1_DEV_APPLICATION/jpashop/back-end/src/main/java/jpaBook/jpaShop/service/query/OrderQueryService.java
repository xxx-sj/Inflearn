package jpaBook.jpaShop.service.query;


import jpaBook.jpaShop.api.OrderApiController;
import jpaBook.jpaShop.domain.Order;
import jpaBook.jpaShop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public List<OrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        return orders.stream().map(order -> new OrderDto(order))
                .collect(Collectors.toList());
    }
}

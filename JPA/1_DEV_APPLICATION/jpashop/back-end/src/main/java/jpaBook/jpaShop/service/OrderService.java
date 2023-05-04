package jpaBook.jpaShop.service;

import jpaBook.jpaShop.controller.order.dto.OrderListResponseDto;
import jpaBook.jpaShop.domain.Delivery;
import jpaBook.jpaShop.domain.Member;
import jpaBook.jpaShop.domain.Order;
import jpaBook.jpaShop.domain.OrderItem;
import jpaBook.jpaShop.domain.item.Item;
import jpaBook.jpaShop.repository.ItemRepository;
import jpaBook.jpaShop.repository.MemberRepository;
import jpaBook.jpaShop.repository.OrderRepository;
import jpaBook.jpaShop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);

        //orderItem, delivery persist 안하는 이유는
        // cascade.ALL 로 되어있기 때문이다.
        //cascade.ALL 은 사용하는 곳이 한 곳일 때만 사용하는 법
        /**
         * delivery, orderItem을 order에서만 사용하기 때문에
         * 다른곳에서 사용할 경우 어디서 발생하는지 찾기어렵기 때문에
         * 이해하지 못한다면 사용하지 않는것을 추천
         */

        return order.getId();

    }

    /**
     * 주문취소
     */
    @Transactional
    public Long cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        //띠로 update 쿼리를 사용하지 않아도, 현재
        /**
         * find를 통해 가져온 데이터를 갖고 트랜잭션 내에서 cancle method를 통해
         * order의 status와 item quantity를 수정한다.
         */
        order.cancel();

        return order.getId();
    }

    //검색
    public List<OrderListResponseDto> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByString(orderSearch).stream()
                .map(order -> new OrderListResponseDto(order))
                .collect(Collectors.toList());
    }
}

package jpaBook.jpaShop.controller.order;

import jpaBook.jpaShop.controller.order.dto.OrderListResponseDto;
import jpaBook.jpaShop.domain.Order;
import jpaBook.jpaShop.repository.OrderSearch;
import jpaBook.jpaShop.service.ItemService;
import jpaBook.jpaShop.service.MemberService;
import jpaBook.jpaShop.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @PostMapping("/orders")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {

        orderService.order(memberId, itemId, count);

        return null;
    }

    @GetMapping("/orders")
    public List<OrderListResponseDto> orderList(@ModelAttribute OrderSearch orderSearch) {
        return orderService.findOrders(orderSearch);
    }
}

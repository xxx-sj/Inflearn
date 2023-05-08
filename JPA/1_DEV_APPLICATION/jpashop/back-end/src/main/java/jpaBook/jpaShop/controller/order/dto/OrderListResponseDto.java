package jpaBook.jpaShop.controller.order.dto;

import jpaBook.jpaShop.domain.Order;
import jpaBook.jpaShop.domain.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderListResponseDto {

    private Long id;
    private String memberName;
    private String orderItemName;
    private int orderPrice;
    private int count;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

    public OrderListResponseDto(Order order) {
        this.id = order.getId();
        this.memberName = order.getMember().getName();
        this.orderItemName = order.getOrderItems().get(0).getItem().getName();
        this.orderPrice = order.getOrderItems().get(0).getOrderPrice();
        this.count = order.getOrderItems().get(0).getCount();
        this.orderStatus = order.getStatus();
        this.orderDate = order.getOrderDate();
    }
}

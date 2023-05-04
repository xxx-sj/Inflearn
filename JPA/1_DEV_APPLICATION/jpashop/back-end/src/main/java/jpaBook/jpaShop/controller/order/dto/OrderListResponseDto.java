package jpaBook.jpaShop.controller.order.dto;

import jpaBook.jpaShop.domain.Order;
import jpaBook.jpaShop.domain.OrderStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class OrderListResponseDto {
    private Long id;
    private String memberName;
    private String itemName;
    private int price;
    private int count;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

    public OrderListResponseDto(Order order) {
        this.id = order.getId();
        this.memberName = order.getMember().getName();
        this.itemName = order.getOrderItems().get(0).getItem().getName();
        this.price = order.getOrderItems().get(0).getOrderPrice();
        this.count = order.getOrderItems().get(0).getCount();
        this.orderStatus = order.getStatus();
        this.orderDate = order.getOrderDate();
    }

}

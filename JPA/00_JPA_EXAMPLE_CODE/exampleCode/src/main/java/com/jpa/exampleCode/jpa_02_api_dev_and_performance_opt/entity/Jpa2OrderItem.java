package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.item.Jpa2Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Jpa2OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Jpa2Item item;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Jpa2Order order;

    private int orderPrice; //주문 가격
    private int count; //주문 수량

    //==생성 메서드==//
    public static Jpa2OrderItem createOrderItem(Jpa2Item item, int orderPrice, int count) {
        Jpa2OrderItem orderItem = new Jpa2OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    //==비즈니스 로직==//
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회 로직==//

    /**
     * 주문상품 전체 가격 조회
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}

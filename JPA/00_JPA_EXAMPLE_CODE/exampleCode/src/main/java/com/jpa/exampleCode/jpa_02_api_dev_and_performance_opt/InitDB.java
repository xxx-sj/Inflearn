package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.*;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.item.Jpa2Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * 종 주문 2개
 * * userA
 * 	 * JPA1 BOOK
 * 	 * JPA2 BOOK
 * * userB
 * 	 * SPRING1 BOOK
 * 	 * SPRING2 BOOK
 */
@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            Jpa2Member member = createMember("userA", "서울", "1", "1111");
            em.persist(member);

            Jpa2Book book1 = createBook("JPA1 BOOK", 10000, 100);
            em.persist(book1);

            Jpa2Book book2 = createBook("JPA2 BOOK", 20000, 100);
            em.persist(book2);

            Jpa2OrderItem orderItem1 = Jpa2OrderItem.createOrderItem(book1, 10000, 1);
            Jpa2OrderItem orderItem2 = Jpa2OrderItem.createOrderItem(book2, 20000, 2);

            Jpa2Delivery delivery = createDelivery(member);
            Jpa2Order order = Jpa2Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        public void dbInit2() {
            Jpa2Member member = createMember("userB", "진주", "2", "2222");
            em.persist(member);

            Jpa2Book book1 = createBook("SPRING1 BOOK", 20000, 200);
            em.persist(book1);

            Jpa2Book book2 = createBook("SPRING2 BOOK", 40000, 300);
            em.persist(book2);

            Jpa2OrderItem orderItem1 = Jpa2OrderItem.createOrderItem(book1, 20000, 3);
            Jpa2OrderItem orderItem2 = Jpa2OrderItem.createOrderItem(book2, 40000, 4);

            Jpa2Delivery delivery = createDelivery(member);
            Jpa2Order order = Jpa2Order.createOrder(member, delivery, orderItem1, orderItem2);
            em.persist(order);
        }

        private Jpa2Member createMember(String name, String city, String street, String zipcode) {
            Jpa2Member member = new Jpa2Member();
            member.setName(name);
            member.setAddress(new Jpa2Address(city, street, zipcode));
            return member;
        }

        private Jpa2Book createBook(String name, int price, int stockQuantity) {
            Jpa2Book book1 = new Jpa2Book();
            book1.setName(name);
            book1.setPrice(price);
            book1.setStockQuantity(stockQuantity);
            return book1;
        }

        private Jpa2Delivery createDelivery(Jpa2Member member) {
            Jpa2Delivery delivery = new Jpa2Delivery();
            delivery.setAddress(member.getAddress());
            return delivery;
        }
    }
}



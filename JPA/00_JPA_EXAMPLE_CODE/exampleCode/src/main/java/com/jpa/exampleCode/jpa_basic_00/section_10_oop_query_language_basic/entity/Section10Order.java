package com.jpa.exampleCode.jpa_basic_00.section_10_oop_query_language_basic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Section10Order {
    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Section10Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Section10Product product;

}

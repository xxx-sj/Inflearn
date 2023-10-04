package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Jpa2Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Jpa2Order order;

    @Embedded
    private Jpa2Address address;

    @Enumerated(EnumType.STRING)
    private Jpa2DeliveryStatus status; //READY, COMP
}

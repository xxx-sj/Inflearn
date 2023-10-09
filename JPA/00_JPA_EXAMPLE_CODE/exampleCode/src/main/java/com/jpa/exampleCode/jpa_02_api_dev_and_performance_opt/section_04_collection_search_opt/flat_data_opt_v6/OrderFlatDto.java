package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.section_04_collection_search_opt.flat_data_opt_v6;

import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.Jpa2Address;
import com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.Jpa2OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderFlatDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private Jpa2OrderStatus orderStatus;
    private Jpa2Address address;
    private String itemName;
    private int orderPrice;
    private int count;

    public OrderFlatDto(Long orderId, String name, LocalDateTime orderDate, Jpa2OrderStatus orderStatus, Jpa2Address address, String itemName, int orderPrice, int count) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}

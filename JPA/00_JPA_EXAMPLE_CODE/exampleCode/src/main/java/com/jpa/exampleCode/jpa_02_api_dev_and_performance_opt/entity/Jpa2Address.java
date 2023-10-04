package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Jpa2Address {

    private String city;
    private String street;
    private String zipcode;

    protected Jpa2Address() {
    }

    public Jpa2Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}

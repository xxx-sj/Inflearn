package com.jpa.exampleCode.jpa_02_api_dev_and_performance_opt.entity.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Jpa2Album extends Jpa2Item {

    private String artist;
    private String etc;
}


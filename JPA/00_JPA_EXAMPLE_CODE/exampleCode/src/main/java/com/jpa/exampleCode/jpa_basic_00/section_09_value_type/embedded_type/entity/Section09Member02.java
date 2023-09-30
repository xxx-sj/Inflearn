package com.jpa.exampleCode.jpa_basic_00.section_09_value_type.embedded_type.entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Section09Member02 {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Embedded
    private Section09Address02 homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE")),
//            @AttributeOverride(name = "testEntity", column = @Column(name = "WORK_TEST_ENTITY"))
    })
    @Embedded
    private Section09Address02 workAddress;
}

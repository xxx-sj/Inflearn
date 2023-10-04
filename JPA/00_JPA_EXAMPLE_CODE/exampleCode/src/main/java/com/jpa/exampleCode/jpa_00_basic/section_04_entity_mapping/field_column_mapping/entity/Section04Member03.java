package com.jpa.exampleCode.jpa_00_basic.section_04_entity_mapping.field_column_mapping.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Section04Member03 {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Enumerated(value = EnumType.STRING)
    private Section04EntityStatus03 entityStatus;

    @Lob
    private String lobDate;

    @Transient
    private String transientData;
}

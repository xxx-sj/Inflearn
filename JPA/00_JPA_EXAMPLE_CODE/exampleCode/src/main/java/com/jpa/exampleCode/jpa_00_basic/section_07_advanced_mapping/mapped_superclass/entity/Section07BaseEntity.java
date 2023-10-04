package com.jpa.exampleCode.jpa_00_basic.section_07_advanced_mapping.mapped_superclass.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class Section07BaseEntity {

    @Column(name = "INSERT_MEMBER")
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;
}

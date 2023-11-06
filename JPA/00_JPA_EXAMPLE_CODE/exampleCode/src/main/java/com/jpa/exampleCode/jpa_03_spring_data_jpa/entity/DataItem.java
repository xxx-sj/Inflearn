package com.jpa.exampleCode.jpa_03_spring_data_jpa.entity;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class DataItem extends BaseEntity implements Persistable<String> {

    @Id
    private String id;

    protected DataItem() {}

    public DataItem(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return getCreatedBy() == null;
    }
}

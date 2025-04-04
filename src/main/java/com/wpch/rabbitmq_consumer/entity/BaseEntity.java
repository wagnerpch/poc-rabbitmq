package com.wpch.rabbitmq_consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    public static final String COLUMN_CREATE_AT = "created_at";
    public static final String COLUMN_DELETE_AT = "deleted_at";

    @Column(name = COLUMN_CREATE_AT)
    private OffsetDateTime createdAt;

    @Column(name = COLUMN_DELETE_AT)
    private OffsetDateTime deletedAt;
}
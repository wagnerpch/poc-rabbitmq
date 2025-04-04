package com.wpch.rabbitmq_consumer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(
        name = PersonEntity.NAME_TABLE,
        schema = PersonEntity.SCHEMA
)
@Getter
@Setter
public class PersonEntity extends BaseEntity {

    public static final String SCHEMA = "data";
    public static final String NAME_TABLE = "person";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    @Id
    @Column(name = COLUMN_ID)
    private UUID id;

    @Column(name = COLUMN_NAME)
    private String name;
}
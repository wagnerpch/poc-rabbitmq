package com.wpch.rabbitmq_consumer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class PersonDTO {

    private UUID id;
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime deletedAt;
}
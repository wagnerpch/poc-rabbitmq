package com.wpch.rabbitmq_consumer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonRequestDTO {

    @NotNull
    private String name;
}
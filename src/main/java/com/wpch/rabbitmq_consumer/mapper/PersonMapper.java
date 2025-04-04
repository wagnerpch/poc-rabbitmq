package com.wpch.rabbitmq_consumer.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.wpch.rabbitmq_consumer.dto.PersonDTO;
import com.wpch.rabbitmq_consumer.entity.PersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.wpch.rabbitmq_consumer.utils.JsonValidationUtils.hasJsonNodeAndNotNull;
import static com.wpch.rabbitmq_consumer.utils.JsonValidationUtils.hasValidCreatedAt;

@Component
public class PersonMapper {

    private final ModelMapper modelMapper;

    public PersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PersonDTO fromJson(JsonNode jsonNode) {
        PersonDTO dto = new PersonDTO();
        setId(jsonNode, dto);
        setName(jsonNode, dto);
        setCreatedAt(jsonNode, dto);
        return dto;
    }

    public PersonEntity toEntity(PersonDTO dto) {
        return modelMapper.map(dto, PersonEntity.class);
    }

    public PersonDTO toDto(PersonEntity entity) {
        return modelMapper.map(entity, PersonDTO.class);
    }

    private static void setId(JsonNode jsonNode, PersonDTO dto) {
        if (hasJsonNodeAndNotNull(jsonNode, "id")) {
            dto.setId(UUID.fromString(jsonNode.get("id").asText()));
        }
    }

    private static void setName(JsonNode jsonNode, PersonDTO dto) {
        if (hasJsonNodeAndNotNull(jsonNode, "name")) {
            dto.setName(jsonNode.get("name").asText());
        }
    }

    private static void setCreatedAt(JsonNode jsonNode, PersonDTO dto) {
        if (hasValidCreatedAt(jsonNode)) {
            dto.setCreatedAt(OffsetDateTime.parse(jsonNode.get("created_at").asText()));
        } else {
            dto.setCreatedAt(OffsetDateTime.now());
        }
    }
}
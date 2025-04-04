package com.wpch.rabbitmq_consumer.utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JsonValidationUtils {

    public static boolean hasValidCreatedAt(JsonNode jsonNode) {
        if (hasJsonNodeAndNotNull(jsonNode, "created_at")) {
            JsonNode createdAtNode = jsonNode.get("created_at");
            if (createdAtNode.isTextual()) {
                try {
                    OffsetDateTime.parse(createdAtNode.asText(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            } else if (createdAtNode.isNumber()) {
                try {
                    OffsetDateTime.ofInstant(Instant.ofEpochMilli(createdAtNode.asLong()), ZoneOffset.UTC);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean hasJsonNodeAndNotNull(JsonNode jsonNode, String fieldName) {
        return jsonNode.has(fieldName) && !jsonNode.get(fieldName).isNull();
    }
}
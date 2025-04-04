package com.wpch.rabbitmq_consumer.repository;

import com.wpch.rabbitmq_consumer.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}

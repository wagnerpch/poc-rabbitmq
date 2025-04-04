package com.wpch.rabbitmq_consumer.service;

import com.wpch.rabbitmq_consumer.dto.PersonDTO;
import com.wpch.rabbitmq_consumer.entity.PersonEntity;
import com.wpch.rabbitmq_consumer.mapper.PersonMapper;
import com.wpch.rabbitmq_consumer.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(
            PersonRepository personRepository,
            PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public void savePerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        personRepository.save(entity);
    }
}
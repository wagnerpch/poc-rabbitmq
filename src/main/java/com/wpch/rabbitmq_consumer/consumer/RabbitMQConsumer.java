package com.wpch.rabbitmq_consumer.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.wpch.rabbitmq_consumer.dto.PersonDTO;
import com.wpch.rabbitmq_consumer.mapper.PersonMapper;
import com.wpch.rabbitmq_consumer.service.PersonService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import static com.wpch.rabbitmq_consumer.utils.PersonUtils.errorMsg;
import static com.wpch.rabbitmq_consumer.utils.PersonUtils.successMsg;

@Component
public class RabbitMQConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PersonMapper personMapper;
    private final PersonService personService;

    public RabbitMQConsumer(
            PersonMapper personMapper,
            PersonService personService) {
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @RabbitListener(queues = "#{rabbitMQConfig.getQueueName()}", concurrency = "5-10", ackMode = "MANUAL")
    public void receiveMessage(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            PersonDTO personDTO = personMapper.fromJson(jsonNode);
            personService.savePerson(personDTO);

            successMsg(personDTO);

            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            errorMsg(e);

            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (Exception ex) {
                errorMsg(e);
            }
        }
    }
}
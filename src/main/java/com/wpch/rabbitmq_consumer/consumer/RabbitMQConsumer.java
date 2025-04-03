package com.wpch.rabbitmq_consumer.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "#{rabbitMQConfig.getQueueName()}", concurrency = "5-10", ackMode = "MANUAL")
    public void receiveMessage(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String id = jsonNode.get("id").asText();
            String name = jsonNode.get("name").asText();

            System.out.println("✅ Mensagem Recebida -> ID: " + id + ", Nome: " + name);

            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            System.err.println("❌ Erro ao processar mensagem: " + e.getMessage());

            try {
                channel.basicNack(deliveryTag, false, true);
            } catch (Exception ex) {
                System.err.println("❌ Erro ao rejeitar mensagem: " + ex.getMessage());
            }
        }
    }
}

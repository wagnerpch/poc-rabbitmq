package com.wpch.rabbitmq_consumer.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String QUEUE_NAME = dotenv.get("RABBITMQ_QUEUE");
    private static final String EXCHANGE_NAME = dotenv.get("RABBITMQ_EXCHANGE");
    private static final String ROUTING_KEY = dotenv.get("RABBITMQ_ROUTING_KEY");

    static {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    public static String getQueueName() {
        return QUEUE_NAME;
    }
}

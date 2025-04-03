# POC Consumir com Java/Spring Boot as mensagens do RabbitMQ
POC Consumir com Java/Spring Boot as mensagens do RabbitMQ criadas com Python ou Java

[![Static Badge](https://img.shields.io/badge/license-GNU-green)](https://github.com/wagnerpch/poc-rabbitmq/blob/main/LICENSE)

# Sobre o projeto

Aplicação backend em Java 21 com Spring Boot.

Essa prova de conceito foi desenvolvida para testar o consumo de mensagens de forma assíncrona registradas no RabbitMQ usando Java e Spring Boot.

O foco não foi o producer nesse primeiro momento, por isso foi criado um producer usando Python/Pika.

# Tecnologias utilizadas

## Back-end

- Java 21
- Spring Boot Web
- RabbitMQ
- Python/Pika

## Dependências:
- spring-boot-starter-web
- spring-boot-devtools
- h2
- lombok
- spring-boot-starter-test
- 

# Como executar o projeto

## Back end

Pré-requisitos: Java

```bash
# clonar repositório
git clone https://github.com/wagnerpch/poc-rabbitmq

# acessar a pasta
cd poc-rabbitmq

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Wagner Pereira Chequeleiro

https://www.linkedin.com/in/wagnerpch/
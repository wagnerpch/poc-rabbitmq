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
- dotenv-java
- spring-boot-starter-web
- lombok
- spring-boot-starter-amqp
- jackson-databind
- spring-boot-devtools
- spring-boot-starter-data-jpa
- postgresql
- flyway-core
- flyway-database-postgresql
- modelmapper
- spring-boot-starter-actuator
- springdoc-openapi-starter-webmvc-ui
- spring-boot-starter-test
- spring-rabbit-test
- instancio

# Como executar o projeto

## Back end

Pré-requisitos: Java versão 23, RabbitMQ, Docker, Dbeaver

1) Projeto Python - Producer

```bash
# clonar repositório
git clone https://github.com/wagnerpch/python-testados/tree/main/rabbitmq-producer

# acessar a pasta
cd python-testados/rabbitmq-producer

# executar o projeto
python producer.py
```

2) RabbitMQ no Docker

```bash
# Crie o arquivo do docker compose

services:
  rabbitmq-service:
    image: "rabbitmq:3.7-management"
    container_name: rabbitmq
    environment:
      RABBITMQ_DEFAULT_USER: "admin"
      RABBITMQ_DEFAULT_PASS: "admin"
      RABBITMQ_DEFAULT_VHOST: "/"
    ports:
      - "15672:15672"  # Management UI
      - "5672:5672"    # Connection port
    volumes:
      - rabbitmq_data:/var/lib/rabbitmq
    restart: unless-stopped

volumes:
  rabbitmq_data:

# Execute o seguinte comando:
docker compose up
```

3) PostgreSQL no Docker e criar database

```bash
# Docker PostgreSQL 17.0
docker run -d --name pg -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v /usr/local/pgsql/data17:/var/lib/postgresql/data postgres:17.0

# Criar database
CREATE DATABASE person;
CREATE USER dbeaver_user WITH ENCRYPTED PASSWORD 'postgres';
GRANT CONNECT ON DATABASE person TO postgres;
GRANT ALL PRIVILEGES ON DATABASE person TO postgres;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO postgres;

```

4) Projeto Java - Consumer

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
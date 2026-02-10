# FastFood-Microservice

# 🍔 FoodFast – Sistema de Pedidos com Microserviços

Projeto de estudo utilizando **Java + Spring Boot + Kafka**, simulando um sistema simples de pedidos para uma empresa fictícia de delivery de comida.

O objetivo é praticar conceitos fundamentais de **microserviços**, **eventos assíncronos** e **boas práticas de organização de código**, com um nível de complexidade adequado para **desenvolvedor júnior**.

---

## 📌 Visão Geral

O sistema é composto por dois microserviços independentes:

- **order-service**  
  Responsável pela criação e gerenciamento de pedidos.

- **notification-service**  
  Responsável por consumir eventos Kafka e simular o envio de notificações.

A comunicação entre os serviços é feita de forma **assíncrona**, utilizando **Apache Kafka**.

O projeto utiliza Git Flow simplificado, com branches main, develop e branches de feature.

---

## 🧠 Regras de Negócio

### Pedido

- Um pedido deve conter:
  - Nome do cliente
  - Nome do restaurante
  - Valor total

- O valor total do pedido deve ser **maior que zero**

### Status do Pedido

Status possíveis:
- `CREATED`
- `CONFIRMED`
- `DELIVERED`
- `CANCELED`

Regras de transição:
- `CREATED → CONFIRMED`
- `CONFIRMED → DELIVERED`
- `CREATED → CANCELED`

Regras inválidas:
- Não é permitido voltar o status
- Não é permitido cancelar um pedido já entregue

---

## 🧩 Arquitetura

[ order-service ] --> (Kafka Event)--> [ notification-service ]


- Cada microserviço possui seu próprio contexto
- Comunicação entre serviços via eventos Kafka
- Sem acoplamento direto entre serviços


## 🗄️ Modelo de Dados (ERD)

### order-service
````
+----------------------+
| orders               |
+----------------------+
| id                   |
| customer_name        |
| restaurant_name      |
| total_value          |
| status               |
| created_at           |
+----------------------+
````

### notification-service
````

+---------------------+
|    notifications    |
+---------------------+
| id                  |
| order_id            |
| type                |
| message             |
| status              |
| created_at          |  
| sent_at             |
+---------------------+


````

## 📡 Comunicação via Kafka

### Tópico
order-status-events


### Evento Publicado

```json
{
  "orderId": "uuid",
  "status": "CONFIRMED",
  "changedAt": "2026-02-10T14:30:00"
}
````
Esse evento é publicado sempre que o status de um pedido é alterado.

## 📁 Estrutura de Pastas
```json
order-service
└── src/main/java
    └── com.foodfast.order
        ├── controller
        ├── service
        ├── repository
        ├── entity
        ├── dto
        ├── event
        └── config
notification-service
└── src/main/java
    └── com.foodfast.notification
        ├── consumer
        ├── event
        └── config
````
🚀 Tecnologias Utilizadas

- Java 21

- Spring Boot

- Spring Web

- Spring Data JPA

- Apache Kafka

- PostgreSQL

- Maven

- Docker (Kafka)

- Lombok

🧪 Como Executar o Projeto (em breve)

Esta seção será preenchida conforme o desenvolvimento do projeto.

📌 Status do Desenvolvimento

 - [x] Definição do domínio e regras de negócio

 - [x] Definição da arquitetura

 - [ ] Criação do order-service

 - [ ] Criação do notification-service

 - [ ] Configuração do Kafka

 - [ ] Publicação de eventos

 - [ ] Consumo de eventos

 - [ ] Testes básicos

🎯 Objetivo do Projeto

- Consolidar conhecimentos em Spring Boot

- Introduzir comunicação assíncrona com Kafka

- Aplicar conceitos básicos de microserviços

- Criar um projeto realista para portfólio

## 👨‍💻 Autor

Daniel Nascimento Firmiano

Desenvolvedor de Software Júnior | Backend

Java • Spring Boot • Kafka


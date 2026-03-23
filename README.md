# 📦 PSS – Producer-Consumer Inventory System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logo=lombok&logoColor=white)

---

## 📌 Overview

This project is a **Producer-Consumer Inventory System (PSS)** built as a multi-module Spring Boot application using **Apache Kafka** for message streaming. It demonstrates core concepts of event-driven architecture by decoupling producers and consumers through a Kafka broker, with an inventory module tracking state changes.

---

## 🗂️ Project Structure

```
ITS120-Act1/
├── producer/           # Publishes messages/events to Kafka topics
├── consumer/           # Subscribes to Kafka topics and processes events
├── inventory/          # Tracks inventory state from consumed events
├── pssdata/            # Shared data models and entities
├── docker-compose.yml  # Kafka broker setup
└── pom.xml             # Parent Maven POM
```

---

## ⚙️ Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 2.7.5 |
| Messaging | Apache Kafka |
| ORM | Spring Data JPA + Jakarta Persistence |
| Utilities | Lombok |
| Build Tool | Maven |
| Containerization | Docker |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- Docker & Docker Compose

### 1. Start Kafka with Docker

```bash
docker-compose up -d
```

This spins up an Apache Kafka broker on `localhost:9092` with 3 partitions.

### 2. Build the project

```bash
mvn clean install
```

### 3. Run the modules

```bash
# Start producer
cd producer && mvn spring-boot:run

# Start consumer
cd consumer && mvn spring-boot:run

# Start inventory
cd inventory && mvn spring-boot:run
```

---

## 🐳 Kafka Configuration

The `docker-compose.yml` sets up a single-node Kafka broker in KRaft mode (no Zookeeper):

| Property | Value |
|---|---|
| Image | `apache/kafka:latest` |
| Port | `9092` |
| Partitions | 3 |
| Mode | KRaft (broker + controller) |

---

## 📋 Module Overview

**`producer`** — Publishes events or data to a Kafka topic. Acts as the entry point for new data into the system.

**`consumer`** — Listens to Kafka topics and processes incoming messages. Handles business logic upon receiving events.

**`inventory`** — Maintains the current state of inventory based on consumed events.

**`pssdata`** — Shared library containing common data models and JPA entities used across all modules.

---

## 👤 Author

**shrkocat** — [github.com/shrkocat](https://github.com/shrkocat)

> ITS120 – Activity 1 | Mapua University

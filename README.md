🏗️ Modular Monolith: Calculator & Payments (DDD)

A pragmatic implementation of a Modular Monolith using Domain-Driven Design (DDD) and Clean Architecture principles with Spring Boot.
🎯 Project Overview

The goal of this project is to demonstrate a decoupled communication strategy between two distinct business domains using Spring Application Events.

    Calculator Module: Handles mathematical operations and publishes an event once a calculation is validated.

    Payment Module: Listens for calculation events to automatically trigger the billing/payment process.

🛠️ Tech Stack

    Java 17

    Spring Boot 3

    Maven (Multi-module structure)

    Patterns: DDD (Aggregates, Value Objects), Clean Architecture, Domain Events.

📂 Project Structure

The project is divided into isolated Maven modules to prevent tight coupling and cyclic dependencies:

    common: Shared logic, base types, and the DomainEvent interface.

    business-calculator: The core logic for math operations.

    business-payment: The logic for processing transactions.

    app: The Spring Boot entry point and global configuration.

🔄 How it Works (Event-Driven)

To keep modules independent, they never call each other directly. Instead, they communicate through events:

    Calculator finishes a task and publishes an OperationValidatedEvent.

    Payment has a listener (@EventListener) that catches this event.

    The payment starts automatically without the Calculator knowing it even exists.

🚀 Getting Started
Prerequisites

    JDK 17

    Maven 3.x

Installation
Bash

# Clone the repository
https://github.com/HamedSawadogo/Spring-Hex-Archi-and-DDD-concepts.git

# Build all modules
mvn clean install

# Run the application
mvn spring-boot:run -pl app

🧠 Key Architecture Benefits

    Maintainability: Changes in the Payment logic do not affect the Calculator.

    Testability: Each domain can be tested in total isolation.

    Scalability: This structure makes it very easy to extract a module into a Microservice later if needed.

My "Lead" Perspective:

This README shows that you don't just "write code," but you "design systems." It highlights that you understand how to manage complexity and avoid the "Big Ball of Mud" by using a modular approach.

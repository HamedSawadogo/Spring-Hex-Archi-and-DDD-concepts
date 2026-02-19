# Spring-Hex-Archi-and-DDD-concepts
# 🧩 Spring Hexagonal Architecture & DDD Concepts

Ce projet est un **exemple pédagogique** montrant comment implémenter une application backend avec :

* ✅ **Hexagonal Architecture (Ports & Adapters)**
* ✅ **Domain-Driven Design (DDD)**
* ✅ **Spring Boot**
* ✅ **Event-Driven Concepts (Domain Events)**
* ✅ **Séparation stricte des responsabilités**
* ✅ **Code orienté métier, testable et maintenable**

L’objectif est de démontrer **comment construire une application centrée sur le domaine**, et non sur la base de données ou le framework.

---

## 📐 Architecture utilisée

Ce projet suit l’architecture **Hexagonale** (aussi appelée *Ports & Adapters*).

```
                ┌────────────────────┐
                │   External World   │
                │ (REST, DB, Kafka…) │
                └─────────┬──────────┘
                          │
                ┌─────────▼──────────┐
                │     Adapters       │
                │ Controllers, JPA   │
                └─────────┬──────────┘
                          │
                ┌─────────▼──────────┐
                │ Application Layer  │
                │ Use Cases          │
                └─────────┬──────────┘
                          │
                ┌─────────▼──────────┐
                │    Domain Layer    │
                │ Entities, Rules    │
                └────────────────────┘
```

---

## 🧠 Principes DDD appliqués

### ✔ Aggregates

Les règles métier sont encapsulées dans les **Aggregates**, garants de la cohérence du domaine.

### ✔ Value Objects

Objets immuables représentant un concept métier (ex : `Price`, `Reference`, etc.).

### ✔ Domain Services

Utilisés quand une règle métier ne peut appartenir à une seule entité.

### ✔ Repositories (Ports)

Interfaces définies dans le domaine, implémentées dans les adapters.

### ✔ Domain Events

Les changements importants du domaine produisent des événements.

---

## 📂 Structure du projet

```
src/main/java/com/example/project

├── domain                  → 💎 Cœur métier (indépendant de Spring)
│   ├── model               → Entities / ValueObjects / Aggregates
│   ├── events              → Domain Events
│   ├── repository          → Ports (interfaces)
│
├── application             → Use cases
│   ├── service             → Command Handlers / Orchestration
│   ├── dto                 → Input / Output models
│
├── infrastructure          → Adapters techniques
│   ├── persistence         → JPA / DB implementation
│   ├── configuration       → Spring Config
│   ├── messaging           → Event publishing (optional)
│
├── interfaces              → Entrypoints
│   ├── rest                → Controllers
```

---

## 🚀 Technologies utilisées

* Java 17+
* Spring Boot
* Spring Data JPA
* Maven / Gradle
* H2 / PostgreSQL (selon configuration)
* Lombok (optionnel)

---

## 🎯 Objectifs pédagogiques

Ce projet montre comment :

* ❌ Éviter les architectures **anemic domain model**
* ❌ Éviter la dépendance directe à Spring dans le domaine
* ✔ Faire du domaine **le centre de l’application**
* ✔ Écrire du code **testable sans framework**
* ✔ Préparer une migration vers microservices ou event-driven

---

## 🔍 Exemple de flux (Use Case)

1️⃣ Le contrôleur REST reçoit une requête
2️⃣ Il appelle un **Use Case** de la couche application
3️⃣ Le Use Case manipule l’**Aggregate**
4️⃣ L’Aggregate applique les règles métier
5️⃣ Le Repository (port) est invoqué
6️⃣ L’adapter JPA persiste les données
7️⃣ Un **Domain Event** peut être publié

---

## 🧪 Tests

Le domaine peut être testé **sans Spring** :

```bash
mvn test
```

Les tests unitaires ciblent directement les règles métier.

---

## ▶ Lancer l’application

```bash
git clone https://github.com/your-repo/spring-hex-archi-ddd-concepts.git
cd spring-hex-archi-ddd-concepts
mvn spring-boot:run
```

Application disponible sur :

```
http://localhost:8080
```

---

## 📚 Concepts illustrés

* Clean Architecture
* Tactical DDD
* Aggregates consistency boundary
* Persistence Ignorance
* Use Case driven design
* Separation of Concerns
* Testable Domain Model

---

## ⚠ Important

Le domaine **ne dépend d’aucun framework** :

✔ Pas d’annotations Spring
✔ Pas de dépendance JPA
✔ Pas de logique technique

➡ Le domaine est **pur Java**.

---

## 🤝 Contribution

Les contributions sont bienvenues :

1. Fork le projet
2. Crée une branche
3. Propose une PR

---

## 📖 Ressources utiles

* *Domain-Driven Design* — Eric Evans
* *Implementing DDD* — Vaughn Vernon
* *Hexagonal Architecture* — Alistair Cockburn

---

## 🏁 Conclusion

Ce repository est un **guide pratique** pour comprendre comment :

> Construire une application pilotée par le métier,
> et non par la technologie.

---

✨ Happy Coding — Build software that reflects the business, not the database.

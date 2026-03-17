# Backend Coding Exercise Starter

This is a Spring Boot starter project for a backend engineer coding exercise.
It includes H2 in-memory DB, JPA, and seed data. No business logic is implemented
except a `/instructions` endpoint that serves the instructions page.

## Run

```bash
mvn spring-boot:run
```

- Demo page: http://localhost:8080/instructions
- H2 Console: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:bankdb`
  - User: `sa`
  - Password: (blank)

## Notes
- Schema is defined in `schema.sql`; data in `data.sql`.
- JPA `ddl-auto` is disabled so SQL owns the schema.
#
# Coding Exercise

Implement a simple banking API with **Accounts**, **Balances**, and **Transfers**. The project is preloaded with H2, JPA, and sample data.

## Entities & Tables

### Account (`accounts`)
- id (PK)
- accountId
- name
- accountType (CA | SA)
- currency
- createdAt
- updatedAt

### AccountBalance (`account_balances`)
- accountId (FK 1:1)
- balance
- createdAt
- updatedAt

### Transfer (`transfers`)
- id
- fromAccountId
- toAccountId
- amount
- currency
- transferDateTime
- createdAt
- updatedAt

## What to Build
1. **Get Account Balance** – `GET /accounts/{id}/balance`
2. **Transfer Funds** – `POST /transfers`

## Business Rules
- Accounts must exist and be different
- Amount > 0, up to 2 decimal places
- No overdrafts
- Must use same currency
- Persist Transfer record

## Non-Functional
- Use proper HTTP status codes & JSON errors
- Add basic unit tests

## Notes
- H2 console: `/h2-console`
- JDBC: `jdbc:h2:mem:bankdb`
- User: `sa`, password: *(blank)*
- Schema: `schema.sql`, seed: `data.sql`

Good luck! 🚀

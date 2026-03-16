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

## Tech
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 in-memory database
- Lombok

## Notes
- Schema is defined in `schema.sql`; data in `data.sql`.
- JPA `ddl-auto` is disabled so SQL owns the schema.
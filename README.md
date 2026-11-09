# Employee Manager API

A Spring Boot REST API for managing a company's employee directory: create, list, update and delete employees, each with a generated employee code.

## Stack

- Java 17, Spring Boot (Web, Data JPA)
- MySQL
- Maven wrapper

## Data model

`Employee`: `id`, `name`, `email`, `jobTitle`, `phone`, `imageUrl`, `employeeCode`

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/employee/all` | List all employees |
| GET | `/employee/find/{id}` | Get one employee |
| POST | `/employee/add` | Create an employee |
| POST | `/employee/update` | Update an employee |
| DELETE | `/employee/delete/{id}` | Delete an employee |

## Running locally

1. Create a MySQL database called `employeemanager`.
2. Set your credentials in `src/main/resources/application.properties`.
3. Start the API:

```bash
./mvnw spring-boot:run
```

The API listens on `http://localhost:8080`. The `client/` folder holds the web front end that consumes it.

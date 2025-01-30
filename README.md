# Spring Boot Actor Database API

 ## Project Overview

This is a Spring Boot REST API project for managing an Actor Database. The API allows users to perform CRUD (Create, Read, Update, Delete) operations on actors using Postman for testing.
---


## 🛠️Tech Stack

- Backend: Spring Boot

- bDatabase: MySQL / H2 (for development)

- Testing Tool: Postman

- Build Tool: Maven

- Programming Language - JAVA
  
---
## 🚀 Features

- Add new actors
- Retrieve all actors
- Get actor details by ID
- Update actor information
- Delete an actor

---


# 📡 API Endpoints (Test in Postman)

| HTTP Method | Endpoint       | Description          |
|------------|---------------|----------------------|
| POST       | /actors       | Add a new actor     |
| GET        | /actors       | Get all actors      |
| GET        | /actors/{id}  | Get actor by ID     |
| PUT        | /actors/{id}  | Update actor details |
| DELETE     | /actors       | Delete an actor     |
| GET        | /actors/{name}| fetch the data with name |

---

## Example: Create a New Actor (POST)

- URL: http://localhost:8080/actors

- Headers: Content-Type: application/json

---

## Testing API in Postman

- Open Postman

- Send a POST request to http://localhost:8080/actors

- Use GET to fetch actors

- Update or delete actors using PUT / DELETE

---

## Future Enhancements
-Add pagination for retrieving actors.

-Implement authentication and role-based access.

-Swagger API documentation.

---

## HAPPY CODING

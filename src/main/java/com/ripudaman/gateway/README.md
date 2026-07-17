# Async API Gateway

## Overview

Async API Gateway is a Java application built using Vert.x that demonstrates asynchronous programming.

The application concurrently fetches data from two external REST APIs and combines the responses into a single JSON response using Vert.x Future API and CompositeFuture.

---

## Technologies Used

- Java 17
- Vert.x 5
- Maven
- JUnit 5

---

## Features

- Asynchronous HTTP Requests
- Future API
- CompositeFuture
- REST Endpoint
- JSON Aggregation
- Unit Testing

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.ripudaman.gateway
│   │       ├── handler
│   │       ├── model
│   │       ├── service
│   │       ├── util
│   │       └── MainVerticle.java
│   └── resources
│
└── test
    └── java
        └── com.ripudaman.gateway
            └── GatewayHandlerTest.java
```

---

## API Endpoint

### GET /aggregate

```
http://localhost:8080/aggregate
```

---

## Sample Response

```json
{
  "post_title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "author_name": "Leanne Graham"
}
```

---

## External APIs Used

### Posts API

```
https://jsonplaceholder.typicode.com/posts/1
```

### Users API

```
https://jsonplaceholder.typicode.com/users/1
```

---

## How It Works

1. The client sends a GET request to `/aggregate`.
2. The application makes two asynchronous HTTP requests:
    - Fetch Post details
    - Fetch User details
3. Both requests execute concurrently.
4. `CompositeFuture` waits until both requests complete.
5. The responses are merged into a single JSON object.
6. The aggregated response is returned to the client.

---

## Build

```bash
mvn clean compile
```

---

## Run

```bash
mvn exec:java
```

Server starts on:

```
http://localhost:8080
```

---

## Run Tests

```bash
mvn test
```

---

## Author

**Ripudaman Singh**

Java Backend Developer
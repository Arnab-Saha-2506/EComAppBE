# EComAppBE

EComAppBE is the backend for an e-commerce application. This repository contains the server-side code (Java) that provides REST APIs for product management, user authentication, orders, and other e-commerce functionality.

Repository: [EComAppBE](https://github.com/Arnab-Saha-2506/EComAppBE)  
Primary language: Java  
Default branch: master

## Table of contents
- [Features](#features)
- [Tech stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Build & run](#build--run)
- [Testing](#testing)
- [Contributing](#contributing)
- [Contact](#contact)

## Features
- RESTful API endpoints for core e-commerce workflows (products, categories, users, carts, orders, payments)
- Pagination, filtering and searching endpoints
- Input validation and error handling

## Tech stack
- Java (version: see `build.gradle`)
- Spring Boot
- Persistence: relational DB
- Build: Gradle

## Prerequisites
- Java JDK 11 installed
- Gradle installed
- A relational database (MySQL)
- Optional: Docker & Docker Compose (if there is a compose file)

## Configuration
The application reads configuration from `src/main/resources/application.properties` and environment variables. Provide the following environment variables (example names — replace with actual keys used in your code):

Create a `.env` (or use your environment manager) with values. Example .env:
```env
PORT = <Your_port_num>
Base_URL = https://fakestoreapi.com/ (If you want to implement Fakestore API)
DATASOURCE_URL = jdbc:mysql://localhost:<PORT_NUM>/myEcomAppDB
DATASOURCE_USERNAME = <Your_DB_username>
DATASOURCE_PASSWORD = <You_DB_password>
DATASOURCE_DRIVER_CLASS_NAME = com.mysql.cj.jdbc.Driver
HIBERNATE_DIALECT = org.hibernate.dialect.MySQL8Dialect
```

## Build & run

### Using Gradle
Build:
```bash
./gradlew clean build
```
Run:
```bash
# run jar after build
java -jar build/libs/<artifact-name>.jar

# or during development
./gradlew bootRun
```

Replace `<artifact-name>.jar` with the actual JAR filename produced by the build.

## Testing
Run unit and integration tests with the build tool:

Gradle:
```bash
./gradlew test
```

> Note: This repo is still in-progress, will add loads of features soon. :)

## Contributing
Contributions are welcome. Please:
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes with clear messages
4. Open a Pull Request describing your changes

## Contact
Repository owner: [Arnab-Saha-2506](https://github.com/Arnab-Saha-2506)

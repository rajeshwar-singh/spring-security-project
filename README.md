# Spring Security Project

This project is a Spring Boot application that demonstrates the implementation of authentication and authorization using **Spring Security** and **JWT** (JSON Web Tokens). The application also has a simple domain model for a hospital (with entities like `Doctor`) and uses **Spring Data JPA** to interact with a MySQL database.

---

## 🔍 Table of Contents

- [Features](#-features)  
- [Tech Stack](#-tech-stack)  
- [Getting Started](#-getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Running Locally](#running-locally)  
- [Security Architecture](#-security-architecture)  
- [API Endpoints](#-api-endpoints)  
- [Project Structure](#-project-structure)  
- [Future Improvements](#-future-improvements)  
- [Contributing](#-contributing)  
- [License](#-license)

---

## ✨ Features

- User registration and login (with JWT issuance)  
- Secured APIs (some endpoints require a valid JWT token)  
- CRUD operations for `Doctor` entity  
- Data persistence using Spring Data JPA and MySQL  
- Configuration for Spring Security with JWT filters

---

## 🛠 Tech Stack

- **Java** (17)  
- **Spring Boot**  
- **Spring Security**  
- **Spring Data JPA**  
- **MySQL**  
- **JWT** (using `io.jsonwebtoken:jjwt`)  
- **Gradle** as build tool

---

## 🚀 Getting Started

### Prerequisites

- Java 17  
- MySQL (or any SQL database)  
- Gradle  

### Running Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/rajeshwar-singh/spring-security-project.git
   cd spring-security-project

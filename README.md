# HttpServer Project

## Overview

This project implements a Java-based HTTP server that interacts with a PostgreSQL database. The server is capable of handling HTTP requests for various routes, performing CRUD operations on the database, and sending emails. It uses the `com.sun.net.httpserver.HttpServer` library for handling HTTP requests and the JDBC API for database connectivity.

## Features

- **HTTP Server**: Handles GET, POST, PUT, DELETE requests.
- **Database Integration**: Connects to a PostgreSQL database to perform CRUD operations.
- **Email Sending**: Sends emails using SMTP.
- **JSON Responses**: Uses Gson to convert Java objects to JSON and vice versa.

## Project Structure
```
├── src
│   └── main
│       └── java
│           └── com
│               └── project
│                   └── httpserver
│                       ├── handlers
│                       │   ├── BaseHandler.java
│                       │   ├── DatabaseHandler.java
│                       │   ├── EmployeeHandler.java
│                       │   ├── GoodbyeHandler.java
│                       │   ├── HelloHandler.java
│                       │   ├── ItemHandler.java
│                       │   └── RootHandler.java
│                       ├── model
│                       │   ├── Employee2.java
│                       │   └── MailHandler.java
│                       ├── problemdomain
│                       │   └── HttpServerNew.java
│                       └── repository
│                           ├── DatabaseConnector.java
│                           └── EmployeeDBO.java
└── README.md

```
## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- PostgreSQL database
- Internet connection for sending emails

### Steps to Run

1. **Clone the Repository**:
```bash
git clone https://github.com/yourusername/HttpServer.git
cd HttpServer
```

2. **Set Up PostgreSQL Database**:
    
    - Create a PostgreSQL database named `employee_data`.
    - Create a table `employees` with columns `id`, `name`, `age`, `salary`, `position`.
3. **Configure Database Connection**:
    
    - Open `DatabaseConnector.java`.
    - Update `JDBC_URL`, `USERNAME`, and `PASSWORD` with your PostgreSQL credentials.
4. **Set Up Email Sending**:
    
    - Obtain an app-specific password from your email provider (e.g., Gmail).
    - Open `MailHandler.java`.
    - Update `username` and `password` with your email and app password.
5. **Build and Run the Server**:
    
    - Compile the project:
      ```bash
        javac -d bin src/main/java/com/project/httpserver/**/*.java
      ```
    - Run the server:
      ```bash
        java -cp bin main.java.com.project.httpserver.problemdomain.HttpServerNew 8080
      ```
6. **Access the Server**:
    
    - Open your web browser and navigate to `http://localhost:8080`.


Endpoints

- **Root**: `GET /`
- **Hello**: `GET /hello`
- **Goodbye**: `GET /goodbye`
- **Employee CRUD**:
    - `GET /employee/{id}`
    - `GET /employee/all`
    - `POST /employee`
    - `PUT /employee`
    - `DELETE /employee/{id}`
- **Item**: `GET /item`
- **Mail**: `GET /mail`
- **Database**:
    - `GET /database/{id}`
    - `GET /database/all`
    - `POST /database`
    - `PUT /database`
    - `DELETE /database/{id}`

## Key Concepts

- **HTTP Server**: Using `com.sun.net.httpserver.HttpServer` to handle HTTP requests.
- **JDBC**: Java Database Connectivity for interacting with the PostgreSQL database.
- **Gson**: For JSON serialization and deserialization.
- **SMTP**: Simple Mail Transfer Protocol for sending emails.

## ## Acknowledgements

- [com.sun.net.httpserver.HttpServer](https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/package-summary.html)
- [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/)
- [Gson](https://github.com/google/gson)

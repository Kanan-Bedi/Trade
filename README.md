# Trade Management System

## Introduction
The **Trade Management System** is a Java-based application that allows users to manage trades by performing CRUD operations (Create, Read, Update, Delete). The system ensures that the trade versions are valid and checks for correct maturity dates.

## Features
- Add, view, update, and delete trades.
- Validate trade versioning.
- Check for valid maturity dates (trades past their maturity date are marked as expired).
- User-friendly web interface to manage trades.

## Technologies Used
- **Java 8**
- **Spring Boot**: For building the backend.
- **Spring Data JPA**: For data persistence and ORM mapping.
- **Thymeleaf**: For rendering dynamic HTML content.
- **MySQL**: For database management.
- **Bootstrap 4**: For responsive design and UI styling.

## Prerequisites
- **Java 8+** installed
- **MySQL** installed and configured
- **Maven** or **Gradle** for project dependency management
- IDE such as **IntelliJ IDEA** or **Eclipse** for running the project
- **Spring Boot** dependencies and plugins

## Getting Started

### 1. Clone the repository:
```bash
git clone https://github.com/yourusername/trade-management-system.git
```

### 2. Set up MySQL database:
- Create a database called `trade_db`.
```sql
CREATE DATABASE trade_db;
```

- Update your MySQL credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/trade_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the project:
Use Maven or Gradle to build the project.

#### Using Maven:
```bash
mvn clean install
```

### 4. Run the application:
After building the project, run the Spring Boot application.

```bash
mvn spring-boot:run
```

### 5. Access the application:
Open your browser and navigate to:
```
http://localhost:8080
```

## Project Structure

### 1. **Trade.java**
This file defines the `Trade` entity with its properties such as:
- `tradeId`
- `version`
- `counterPartyId`
- `bookId`
- `maturityDate`
- `createdDate`
- `expired`

### 2. **TradeRepository.java**
The `TradeRepository` interface extends `JpaRepository` and provides methods for performing CRUD operations on trade entities.

### 3. **TradeService.java**
This interface defines the service layer for the business logic, including methods to manage trade entities.

### 4. **TradeServiceImpl.java**
The `TradeServiceImpl` class implements the `TradeService` interface and contains the actual business logic such as:
- Trade version validation
- Maturity date checking
- Expiry handling

### 5. **TradeApplication.java**
This is the main class where the Spring Boot application is launched.

## Exception Handling
The system handles common exceptions such as:
- **Invalid Trade Version**: When the trade version is not valid.
- **Maturity Date Check**: Ensures that trades with past maturity dates are marked as expired.

In case of any errors or invalid data, the system will gracefully handle exceptions and may return null values or user-friendly error messages.

## How to Use
1. **Add Trade**: Click the "Add Trade" button, fill in the required details, and submit.
2. **View Trades**: The homepage displays a list of trades along with their details such as version, counterparty, book ID, maturity date, etc.
3. **Edit/Update Trade**: Select a trade from the list, update the details, and save changes.
4. **Delete Trade**: Use the delete button next to a trade to remove it from the system.

## Future Enhancements
- **User authentication** for accessing the trade management system.
- **Audit logs** to track changes in trades.
- **Improved validation** with more comprehensive business rules.

## References
- [Spring Framework Documentation](https://spring.io/projects/spring-framework)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)

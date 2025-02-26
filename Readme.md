# Spring Boot JPA/Hibernate Advanced Mappings

## Project Description
This is a Spring Boot project designed for learning and implementing advanced JPA/Hibernate mappings. It demonstrates various techniques for handling complex entity relationships in a MySQL database.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## Dependencies
The project includes the following dependencies:
- `spring-boot-starter-data-jpa`: Provides JPA and Hibernate integration.
- `mysql-connector-j`: MySQL driver for database connectivity.
- `spring-boot-starter-test`: Used for testing the application.

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd <project-directory>
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```

## Features Covered
- One-to-One Mapping
- One-to-Many & Many-to-One Mapping
- Many-to-Many Mapping
- Inheritance Strategies in Hibernate


# 🐾 Pet Clinic Management System

A full-stack **Spring Boot–based web application** designed to manage pet owners, pets, and veterinary appointments efficiently.
This project demonstrates **clean architecture, RESTful services, database persistence, and security** using industry-standard Java technologies.

---

## 🚀 Features

* Owner registration and management
* Pet addition and tracking
* Veterinary appointment scheduling
* RESTful APIs for appointment operations
* Secure endpoints using Spring Security
* Server-side rendering with Thymeleaf
* Clean layered architecture (Controller–Service–Repository)

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA (Hibernate)
* Spring Security

### Frontend

* Thymeleaf
* HTML5
* CSS3
* JavaScript

### Database & Tools

* MySQL
* Maven
* Embedded Apache Tomcat
* Postman
* Git

---

## 🏗️ Project Architecture

```
Controller Layer
   ↓
Service Layer
   ↓
Repository Layer
   ↓
Database
```

This layered architecture ensures **separation of concerns**, scalability, and easy maintenance.

---

## 📂 Project Structure

```
src/main/java/com/petclinic
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── security
 └── PetClinicApplication.java
```

```
src/main/resources
 ├── templates
 ├── static
 └── application.properties
```

---

## ⚙️ System Requirements

### Hardware

* Intel Core i3 or higher
* 8 GB RAM or more
* Minimum 10 GB free disk space

### Software

* Java JDK 17 or above
* MySQL Server
* Maven
* IntelliJ IDEA / Eclipse / STS
* MySQL Workbench
* Postman

---

## ▶️ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/asha1834/PetClinic
   ```

2. Open the project in your IDE

3. Configure database credentials in `application.properties`

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pet_clinic
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Run the application

   ```bash
   mvn spring-boot:run
   ```

5. Access the application

   ```
   http://localhost:8080
   ```

---

## 🔐 Security

* Authentication and authorization implemented using **Spring Security**
* Secures sensitive endpoints from unauthorized access

---

## 🔮 Future Enhancements

* Role-based access control (Admin/User)
* API documentation using Swagger
* Pagination and sorting
* Exception handling with `@ControllerAdvice`
* Frontend enhancement using React or Angular

---

## 👩‍💻 Author

**Asha**
Java | Spring Boot | Backend Developer

📌 *This project was developed as part of academic learning and hands-on practice with Spring Boot.*

---

⭐ If you like this project, feel free to star the repository!



* Add **screenshots section**
* Add **API endpoints table**
* Add **badges (Java, Spring Boot, MySQL)**
* Make it **portfolio-optimized**

Just say it, macha 😎✨

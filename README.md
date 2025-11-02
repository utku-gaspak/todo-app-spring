# To-Do Web Application (Spring Boot)

A simple To-Do list web application built with the Spring framework. This project demonstrates a full-stack, monolithic application using Spring Boot, Spring Data JPA, and Thymeleaf for the user interface.

It was built as a foundational project to practice core Spring concepts, including:
* Model-View-Controller (MVC) pattern
* Dependency Injection
* Database interaction with Spring Data JPA
* Server-side HTML rendering with Thymeleaf

## Features

* **Create** new tasks with a description.
* **Read** (view) all tasks in a single list.
* **Update** tasks by marking them as "completed" or "not completed".
* **Delete** tasks from the list.

## Technologies Used

* **Backend:** Java 21 & Spring Boot 3+
* **Database:** Spring Data JPA with H2 (In-Memory Database)
* **Frontend (View):** Thymeleaf
* **Build Tool:** Apache Maven
* **Utilities:** Lombok

## How to Run Locally

You must have Java 21 (or newer) and Apache Maven installed on your system.

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/your-username/todo-app-spring.git](https://github.com/your-username/todo-app-spring.git)
    ```
2.  **Navigate to the project directory:**
    ```sh
    cd todo-app-spring
    ```
3.  **Build the project using Maven:**
    * This will compile the code, run tests, and package it into a `.jar` file.
    ```sh
    mvn clean install
    ```
4.  **Run the application:**
    * Find the name of your `.jar` file in the `target/` directory. It will look something like `todo-app-spring-0.0.1-SNAPSHOT.jar`.
    ```sh
    java -jar target/todo-app-spring-0.0.1-SNAPSHOT.jar
    ```
5.  **Open the application:**
    * Once the application is running, open your web browser and go to:
    * `http://localhost:8080`
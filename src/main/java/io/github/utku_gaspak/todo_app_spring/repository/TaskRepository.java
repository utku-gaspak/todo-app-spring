package io.github.utku_gaspak.todo_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.utku_gaspak.todo_app_spring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * This is a Spring Data JPA "Derived Query".
     * By naming the method this way, Spring automatically creates a query that:
     * 1. Checks for the 'description' field.
     * 2. Ignores case (e.g., "Buy Milk" == "buy milk").
     * 3. Returns 'true' if any match is found.
     */
    boolean existsByDescriptionIgnoreCase(String description);
}

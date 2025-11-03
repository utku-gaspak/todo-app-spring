package io.github.utku_gaspak.todo_app_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.utku_gaspak.todo_app_spring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

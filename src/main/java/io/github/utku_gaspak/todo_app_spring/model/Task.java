package io.github.utku_gaspak.todo_app_spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "You should enter a task description")
    private String description;

    @Column(name = "completed", columnDefinition = "boolean default false")
    private boolean completed;
}

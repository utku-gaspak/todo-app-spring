package io.github.utku_gaspak.todo_app_spring.service;

import io.github.utku_gaspak.todo_app_spring.model.Task;
import io.github.utku_gaspak.todo_app_spring.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Object getTaskById(long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void createNewTask(Task task){
        taskRepository.save(task);
    }
}
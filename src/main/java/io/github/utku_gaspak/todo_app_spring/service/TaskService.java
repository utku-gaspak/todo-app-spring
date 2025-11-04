package io.github.utku_gaspak.todo_app_spring.service;

import io.github.utku_gaspak.todo_app_spring.model.Task;
import io.github.utku_gaspak.todo_app_spring.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void createNewTask(Task task){
        taskRepository.save(task);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void toggleTask(long id){
        Task task = getTaskById(id);
        if (task != null){
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
        }
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }
}
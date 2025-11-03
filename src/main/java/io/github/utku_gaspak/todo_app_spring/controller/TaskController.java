package io.github.utku_gaspak.todo_app_spring.controller;

import io.github.utku_gaspak.todo_app_spring.model.Task;
import io.github.utku_gaspak.todo_app_spring.repository.TaskRepository;
import io.github.utku_gaspak.todo_app_spring.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @GetMapping("/tasks/{id}")
    public String taskIdd(@PathVariable long id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-detail";
    }

    @PostMapping("/tasks/new")
    public String createTask(@ModelAttribute Task newTask) {
        taskService.createNewTask(newTask);
        return "redirect:/";
    }

}

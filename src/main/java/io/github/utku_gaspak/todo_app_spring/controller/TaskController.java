package io.github.utku_gaspak.todo_app_spring.controller;

import io.github.utku_gaspak.todo_app_spring.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskRepository taskRepository;

    @GetMapping("/")
    public String homepage(Model model){
        var tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}

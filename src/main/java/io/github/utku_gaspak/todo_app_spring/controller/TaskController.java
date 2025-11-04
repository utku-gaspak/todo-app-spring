package io.github.utku_gaspak.todo_app_spring.controller;

import io.github.utku_gaspak.todo_app_spring.model.Task;
import io.github.utku_gaspak.todo_app_spring.repository.TaskRepository;
import io.github.utku_gaspak.todo_app_spring.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String createTask(@Valid @ModelAttribute("newTask") Task newTask, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            // VALIDATION FAILED:

            //    MUST re-add the 'tasks' list, or your th:each loop
            //    in index.html will crash with a NullPointerException.
            model.addAttribute("tasks", taskService.getAllTasks());
            return "index";
        }
        //    Now, return "index". Spring will automatically re-send
        //    the 'newTask' (with the user's bad data) and the
        //    'bindingResult' (with the errors) to the page.
        taskService.createNewTask(newTask);
        return "redirect:/";
    }

    @GetMapping("/tasks/edit/{id}")
    public String viewEditTask(@PathVariable long id, Model model){
        var task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", taskService.getTaskById(id));
            return "edit-task";}
        return "redirect:/";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTask(@ModelAttribute Task task){
        taskService.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/tasks/toggle/{id}")
    public String toggleTaskCompleted(@PathVariable long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @PostMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
}

package com.example.project2.controler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.Entity.Task;
import com.example.project2.service.TaskService;
import com.example.project2.util.NotificationSender;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }


    // Erreur SRP (statistiques et récupération dans la même méthode)
    @GetMapping("/completed")
    public int countCompletedTasks() {
        return taskService.calculateCompletedTasks(taskService.getAllTasks());
    }


    // Erreur de cohésion (notification dans TaskController)
    @GetMapping("/notifications")
    public void sendNotificationsForTasks() {
        NotificationSender.sendEmail("test@gmail.com", "Task is completed!");
    }
}

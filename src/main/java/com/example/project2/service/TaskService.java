package com.example.project2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project2.Entity.Task;
import com.example.project2.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Erreur SRP (ajout et envoi de notification dans la même méthode)
    public Task addTask(Task task) {
        taskRepository.save(task);
        sendTaskNotification(task);
        return task;
    }

    public int calculateCompletedTasks(List<Task> tasks) { // Erreur SRP (calcul et logging)
        int completed = (int) tasks.stream().filter(Task::isCompleted).count();
        System.out.println("Completed tasks: " + completed);
        return completed;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private void sendTaskNotification(Task task) { // Erreur de cohésion (notification dans TaskService)
        System.out.println("Notification: Task " + task.getTitle() + " has been added.");
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findTasksByProjectId(projectId);
    }
}

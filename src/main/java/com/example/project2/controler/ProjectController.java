/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project2.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.Entity.Project;
import com.example.project2.Entity.Task;
import com.example.project2.Entity.User;
import com.example.project2.exception.ResourceNotFoundException;
import com.example.project2.service.ProjectService;
import com.example.project2.service.TaskService;
import com.example.project2.service.UserService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public ProjectController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    // Erreur SRP (logique utilisateur ici)
    @PostMapping
    public Project createProject(@RequestBody Project project, @RequestParam Long userId) {
        User user = userService.registerUser(new User());
        return projectService.createProject(project, user);
    }

    // Erreur de cohésion (logique utilisateur dans ProjectController)
    @GetMapping("/project/{projectId}")
    public List<Task> getTasks(@PathVariable Long projectId) {
        Optional<Project> project = projectService.getProject(projectId);
        if (project.isEmpty()) {
            throw new ResourceNotFoundException("Project with ID " + projectId + " not found");
        }
        return this.taskService.getTasksByProjectId(project.get().id);
    }
}

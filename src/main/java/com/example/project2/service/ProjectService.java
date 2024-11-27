package com.example.project2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.project2.Entity.Project;
import com.example.project2.Entity.User;
import com.example.project2.repository.ProjectRepository;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project, User user) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProject(long projectId) {
        return projectRepository.findById(projectId);
    }
}

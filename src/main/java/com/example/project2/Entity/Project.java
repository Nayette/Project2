package com.example.project2.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; // Erreur d'encapsulation (public)

    public String name; // Erreur d'encapsulation (public)

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public List<Task> getTasks() { // Erreur d'encapsulation (expose la liste directement)
        return tasks;
    }

    public void setTasks(List<Task> tasks) { // Erreur d'encapsulation
        this.tasks = tasks;
    }
}

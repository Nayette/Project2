package com.example.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project2.Entity.Task;

/**
 *
 * @author oussa
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
// Récupérer les tâches par l'ID du projet
    @Query("SELECT t FROM Task t WHERE t.project.id = :projectId")
    List<Task> findTasksByProjectId(@Param("projectId") Long projectId);
}

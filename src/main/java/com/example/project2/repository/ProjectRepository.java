package com.example.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project2.Entity.Project;

/**
 *
 * @author oussa
 */
public interface ProjectRepository extends JpaRepository<Project, Long>  {

}

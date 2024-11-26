package com.example.project2.repository;

import com.example.project2.Entity.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<CommandEntity, Long> {
}

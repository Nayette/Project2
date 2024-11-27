package com.example.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project2.Entity.User;

/**
 *
 * @author oussa
 */
public interface UserRepository extends JpaRepository<User, Long> {

}

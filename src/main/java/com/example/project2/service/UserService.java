/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.project2.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.project2.Entity.User;
import com.example.project2.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) { // Erreur SRP (enregistrement et validation dans la même méthode)
        if ( user.username == null || "".equals(user.username)) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        return userRepository.save(user);
    }

    public String formatUserCreationDate(User user, LocalDate date) { // Erreur de cohésion (logique de date)
        return "User " + user.username + " created on: " + date.toString();
    }
}
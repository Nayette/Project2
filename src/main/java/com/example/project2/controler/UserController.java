package com.example.project2.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.Entity.User;
import com.example.project2.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Erreur de cohésion (logique des tâches dans UserController)
    @GetMapping("/{userId}/tasks/completed")
    public String getCompletedTasksForUser(@PathVariable Long userId) {
        return "User with ID " + userId + " has completed X tasks.";
    }
}

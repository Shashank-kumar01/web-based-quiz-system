package com.shashank.quizsystem.controller;

import java.util.List;
import java.util.Optional;
import com.shashank.quizsystem.service.UserService;
import com.shashank.quizsystem.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {

        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {

        return userService.getUserById(id);

    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Long id,
                             @RequestBody User updatedUser) {

        return userService.updateUser(id, updatedUser);
    }
}
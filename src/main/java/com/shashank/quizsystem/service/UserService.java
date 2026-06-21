package com.shashank.quizsystem.service;

import com.shashank.quizsystem.entity.User;
import com.shashank.quizsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user) {
        userRepository.save(user);
        return "User Saved Successfully";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }

    public String updateUser(Long id, User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()) {

            User user = optionalUser.get();

            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());

            userRepository.save(user);

            return "User Updated Successfully";
        }

        return "User Not Found";
    }
}
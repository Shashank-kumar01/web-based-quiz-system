package com.shashank.quizsystem.service;
import com.shashank.quizsystem.dto.LoginResponse;
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

        if(userRepository.existsByEmail(user.getEmail())) {
            return "Email Already Exists";
        }

        if(userRepository.existsByUsername(user.getUsername())) {
            return "Username Already Exists";
        }
        user.setRole("USER");
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
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());

            userRepository.save(user);

            return "User Updated Successfully";
        }

        return "User Not Found";
    }
    public LoginResponse loginUser(String login, String password){

        Optional<User> optionalUser =
                userRepository.findByEmailOrUsername(login, login);

        if(optionalUser.isPresent()) {

            User user = optionalUser.get();

            if(user.getPassword().equals(password)) {

                return new LoginResponse(
                        "Login Successful",
                        user.getName(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole()
                );
            }
        }

        return new LoginResponse(
                "Invalid Email or Password",
                null,
                null,
                null,
                null
        );
    }
}
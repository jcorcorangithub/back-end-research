package com.company.controller;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user") // create new user
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }


    @PutMapping("user/{id}") // update user variables
    public User updateUser(@RequestBody User user, @PathVariable int id) {
    User foundUser = userRepository.findByUsername(user.getUsername());

    if (user.getUsername() != foundUser.getUsername()) {
        throw new IllegalArgumentException("User ID must match parameter given!");
    }

    foundUser.setUsername(user.getUsername());
    foundUser.setUsername(user.getUsername());
    foundUser.setFirstName(user.getFirstName());
    foundUser.setLastName(user.getLastName());
    foundUser.setEmail(user.getEmail());
    foundUser.setPassword(user.getPassword());
    return userRepository.save(foundUser);
    }

    @DeleteMapping("/user/{id}") // delete user
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}

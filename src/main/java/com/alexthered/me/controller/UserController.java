package com.alexthered.me.controller;

import com.alexthered.me.domain.User;
import com.alexthered.me.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hd on 03.04.17.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository; // our nice repository implementation

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        userRepository.save(user); // using it to persist
        return user;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userRepository.findAll(); // returning all persisted users
    }
}

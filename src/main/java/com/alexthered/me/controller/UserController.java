package com.alexthered.me.controller;

import com.alexthered.me.boundary.UserPostForm;
import com.alexthered.me.domain.User;
import com.alexthered.me.repository.UserRepository;
import com.alexthered.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hd on 03.04.17.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;// our nice repository implementation

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public User saveUser(@Valid @RequestBody UserPostForm userPostForm) {
        User user = userPostForm.buildUser();
        userService.saveUser(user); // using it to persist
        return user;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll(); // returning all persisted users
    }
}

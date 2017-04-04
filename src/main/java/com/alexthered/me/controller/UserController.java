package com.alexthered.me.controller;

import com.alexthered.me.boundary.UserPostForm;
import com.alexthered.me.domain.User;
import com.alexthered.me.service.UserService;
import com.alexthered.me.utils.errors.DuplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody UserPostForm userPostForm)  {

        User duplicatedUser = userService.findByEmail(userPostForm.getEmail());
        if (duplicatedUser != null){
            throw new DuplicationException("Email has already been used!");
        }
        User user = userPostForm.buildUser();

        userService.saveUser(user); // using it to persist
        return user;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findAll(); // returning all persisted users
    }
}

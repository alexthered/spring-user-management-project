package com.alexthered.me.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hd on 17.04.17.
 */
@RestController
public class StatusController {
    @RequestMapping(path = "/status", method = RequestMethod.GET)
    public String getUsers() {
        return "Alles is good"; // returning all persisted users
    }
}

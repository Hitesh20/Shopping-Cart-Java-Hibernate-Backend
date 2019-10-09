package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.model.Users;
import com.caseStudy.eCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UsersController {


    @Autowired
    UserService userService;

    @GetMapping(path = "/validateLogin", produces = "application/json")
    public String validateLogin() { return "\"valid\""; }

    @PostMapping(value = "/addUsers")
    public Users addUser(@RequestBody Users user) { return userService.addUser(user); }
}

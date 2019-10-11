package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.model.Users;
import com.caseStudy.eCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/validateLogin", produces = "application/json")
    public String validateLogin() { return "\"valid\""; }

    @PostMapping(value = "/addUsers")
    public Users addUser(@RequestBody Users user) { return userService.addUser(user); }


    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);

        if(auth!=null)
        {
            new SecurityContextLogoutHandler().logout(request,response,auth);
            request.getSession().invalidate();
        }
        return "/home";
    }
}

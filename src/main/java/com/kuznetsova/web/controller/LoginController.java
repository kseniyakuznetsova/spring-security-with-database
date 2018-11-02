package com.kuznetsova.web.controller;

import com.kuznetsova.web.model.User;
import com.kuznetsova.web.service.UserService;
import com.kuznetsova.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/index**" }, method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security");
        model.addObject("message", "");
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null)
            model.addObject("error", "Invalid username and password!");
        if (logout != null)
            model.addObject("msg", "You've been logged out successfully.");
        model.setViewName("login");
        return model;
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void addUser() {
        User user = new User("1","1","ROLE_USER");
        userService.insertUser(user);
    }
}
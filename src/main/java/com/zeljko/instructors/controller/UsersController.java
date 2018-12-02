package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Users;
import com.zeljko.instructors.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("users_list");
        List<Users> usersList = usersService.getAllUsers();

        model.addObject("usersList", usersList);

        return model;
    }

}

package com.zeljko.instructors.controller;

import com.zeljko.instructors.entities.Users;
import com.zeljko.instructors.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UsersService usersService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("users_list");
        List<Users> usersList = usersService.getAllUsers();

        model.addObject("usersList", usersList);

        return model;
    }

    @RequestMapping(value = "/addUsers/", method = RequestMethod.GET)
    public ModelAndView addUsers() {
        ModelAndView model = new ModelAndView();

        Users users = new Users();

        model.addObject("usersForm", users);
        model.setViewName("users_form");

        return model;
    }

    @RequestMapping(value = "/updateUsers/{id}", method = RequestMethod.GET)
    public ModelAndView editUsers(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Users users = usersService.getUsersById(id);



        model.addObject("usersForm", users);
        model.setViewName("users_form");

        return model;
    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("usersForm") Users users) {
        usersService.saveOrUpdate(users);

        return new ModelAndView("redirect:/users/list");
    }

    @RequestMapping(value = "/deleteUsers/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        usersService.deleteUsers(id);

        return new ModelAndView("redirect:/users/list");
    }

}

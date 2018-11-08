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

    //Unused all below

  /*  @GetMapping(value = "/addUsers/")
    public ModelAndView addUsers() {
        ModelAndView model = new ModelAndView();

        Users users = new Users();

        model.addObject("usersForm", users);
        model.setViewName("users_form");

        return model;
    }

    @GetMapping(value = "/updateUsers/{id}")
    public ModelAndView editUsers(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Users users = usersService.getUsersById(id);
        model.addObject("usersForm", users);
        model.setViewName("users_form");

        return model;
    }

    @PostMapping(value = "/saveUsers")
    public ModelAndView save(@ModelAttribute("usersForm") Users users) {
        usersService.saveOrUpdate(users);

        return new ModelAndView("redirect:/users/list");
    }

    @GetMapping(value = "/deleteUsers/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        usersService.deleteUsers(id);

        return new ModelAndView("redirect:/users/list");
    }
*/
}

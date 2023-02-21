package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.Impl.UserServiceImpl;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user")  UserDTO user, Model model){
        userService.save(user);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{userName}")
    public String update(@PathVariable("userName") String userName, Model model){
        model.addAttribute("user", userService.findById(userName));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO user){

        userService.update(user);

        return "redirect:/user/create";

    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String userName){
        userService.deleteById(userName);
        return "redirect:/user/create";
    }



}

package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskContoller {

    @GetMapping("/create")
    public String taskCreate(Model model){

//        model.addAttribute("projects", projectService.findAll());
//        model.addAttribute("managers", userService.findManagers());

        return "/task/create";
    }
}

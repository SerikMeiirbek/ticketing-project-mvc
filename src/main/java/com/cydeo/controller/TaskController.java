package com.cydeo.controller;

import com.cydeo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;

    @Autowired
    public TaskController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("projects", projectService.findAll());
        return "task/create";
    }
}

package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        return "task/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDTO taskDTO){
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model){
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());
        return "/task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute TaskDTO task){
        taskService.updateWithId(task, id);
        return "redirect:/task/create";
    }

    @GetMapping("/pendingTasks")
    public String pendingTask(Model model){
        model.addAttribute("tasks", taskService.findAll());
        return "/task/pending-tasks";
    }

    @GetMapping("/updatePendingTask/{id}")
    public String updatePendingTask(@PathVariable("id") Long taskId, Model model){
        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("statuses", Status.values());
        return "/task/status-update";
    }

    @PostMapping("/updatePendingTask/{id}")
    public String editPendingTask(@PathVariable("id") Long taskId, TaskDTO task){
        taskService.updateWithId(task, taskId);
        return "redirect:/task/pendingTasks";
    }

    @GetMapping("/archive")
    public String getArchiveTasks(Model model){
        return "/task/archive";
    }



}

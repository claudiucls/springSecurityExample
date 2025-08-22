package com.telacad.exempluSpringSecurity.controllers;

import com.telacad.exempluSpringSecurity.entities.Project;
import com.telacad.exempluSpringSecurity.entities.User;
import com.telacad.exempluSpringSecurity.services.ProjectService;
import com.telacad.exempluSpringSecurity.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    private ProjectService projectService;
    private UserService userService;

    public MainController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/get/{username}")
    public List<Project> getProjectsByCoordinator(@PathVariable String username){
        return projectService.getProjectsByCoordinator(userService.getUserByUsername(username));
    }
}

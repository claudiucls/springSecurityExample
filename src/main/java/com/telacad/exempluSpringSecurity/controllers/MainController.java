package com.telacad.exempluSpringSecurity.controllers;

import com.telacad.exempluSpringSecurity.entities.Project;
import com.telacad.exempluSpringSecurity.entities.User;
import com.telacad.exempluSpringSecurity.services.ProjectService;
import com.telacad.exempluSpringSecurity.services.UserService;
import org.springframework.security.core.Authentication;
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

    @GetMapping()
    public List<Project> getProjectsByCoordinator(Authentication authentication){
        final User userByUsername = userService.getUserByUsername(authentication.getName());
        return projectService.getProjectsByCoordinator(userByUsername);
    }
}

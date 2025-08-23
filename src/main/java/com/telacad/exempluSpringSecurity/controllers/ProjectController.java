package com.telacad.exempluSpringSecurity.controllers;

import com.telacad.exempluSpringSecurity.entities.Project;
import com.telacad.exempluSpringSecurity.entities.User;
import com.telacad.exempluSpringSecurity.model.CustomUserDetails;
import com.telacad.exempluSpringSecurity.repositories.ProjectRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public String viewProjects(Authentication authentication, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        List<Project> projects = projectRepository.findProjectsByCoordinator(user);
        model.addAttribute("projects", projects);
        model.addAttribute("username", user.getUsername());
        return "projects";
    }
}
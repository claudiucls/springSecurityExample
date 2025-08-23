package com.telacad.exempluSpringSecurity.services;

import com.telacad.exempluSpringSecurity.entities.Project;
import com.telacad.exempluSpringSecurity.entities.User;
import com.telacad.exempluSpringSecurity.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjectsByCoordinator(User coordinator){
        return projectRepository.findProjectsByCoordinator(coordinator);
    }
}

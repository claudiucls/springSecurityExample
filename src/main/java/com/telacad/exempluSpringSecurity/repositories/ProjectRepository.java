package com.telacad.exempluSpringSecurity.repositories;

import com.telacad.exempluSpringSecurity.entities.Project;
import com.telacad.exempluSpringSecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findProjectsByCoordinator(User coordinator);
}

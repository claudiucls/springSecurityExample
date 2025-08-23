package com.telacad.exempluSpringSecurity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "coordinator")
    @JsonBackReference
    private User coordinator;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User coordinator) {
        this.coordinator = coordinator;
    }
}

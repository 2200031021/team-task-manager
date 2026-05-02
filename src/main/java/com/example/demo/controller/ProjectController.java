package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    // Create Project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return repo.save(project);
    }

    // Get All Projects
    @GetMapping
    public List<Project> getAllProjects() {
        return repo.findAll();
    }
}
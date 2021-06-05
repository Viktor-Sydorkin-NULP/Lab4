package com.example.project_service.controllers;

import com.example.project_service.models.Project;
import com.example.project_service.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public List<Project> getAllProjects() { return projectService.getAllProjects(); }

    @PostMapping
    public void createProject(@RequestBody Project project) {
        projectService.createProject(project);
    }

    @GetMapping("/{id}")
    public Project findById(@PathVariable long id) {
        return projectService.findById(id);
    }

    @GetMapping("/{projectId}/assign/{developerId}")
    public void assignDeveloperToProject(@PathVariable long projectId, @PathVariable long developerId) {
        projectService.assignDeveloperToProject(projectId, developerId);
    }

    @GetMapping("/{id}/cost")
    public long calculateCostOfProject(@PathVariable long id) {
        return projectService.calculateCostOfProject(id);
    }


}

package com.example.project_service.services;

import com.example.project_service.models.Developer;
import com.example.project_service.models.Project;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private static List<Project> projectList = new ArrayList<>();

    static {
        projectList.add(new Project(1L, 365, new ArrayList<>(), "Fun project!"));
        projectList.add(new Project(2L, 300, new ArrayList<>(), "Test project!"));
        projectList.add(new Project(3L, 365, new ArrayList<>(), "Fake project!"));
    }

    private final RestTemplate restTemplate;

    public List<Project> getAllProjects() {
        return projectList;
    }

    public void createProject(Project project) {
        projectList.add(project);
    }

    public void assignDeveloperToProject(long projectId, long developerId) {
        Project project = findById(projectId);
        Developer developer = restTemplate.getForObject("http://DEVELOPER-SERVICE/developers/" + developerId, Developer.class);
        project.getDeveloperList().add(developer);
    }

    public Project findById(long id) {
        return projectList.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public long calculateCostOfProject(long projectId) {
        Project project = findById(projectId);
        List<Developer> developerList = project.getDeveloperList();
        int daysDuration = project.getDaysDuration();
        long cost = 0;
        for (Developer developer : developerList) {
            cost += (long) developer.getCostPerHour() * 8 * daysDuration;
        }
        return cost;
    }
}

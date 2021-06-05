package com.example.developer_service.controllers;

import com.example.developer_service.models.Developer;
import com.example.developer_service.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    @GetMapping("/all")
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @PostMapping
    public void saveDeveloper(@RequestBody Developer developer) {
        developerService.saveDeveloper(developer);
    }

    @GetMapping("/{id}")
    public Developer findById(@PathVariable long id) {
        return developerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable long id) {
        developerService.deleteDeveloper(id);
    }

    @PutMapping("/{id}")
    public void updateDeveloper(@PathVariable long id, @RequestBody Developer newDeveloper) {
        developerService.updateDeveloper(id, newDeveloper);
    }

    @GetMapping("/{id}/logWork")
    public void logWork(@PathVariable long id, @RequestParam int hours) {
        developerService.logWork(id, hours);
    }
}

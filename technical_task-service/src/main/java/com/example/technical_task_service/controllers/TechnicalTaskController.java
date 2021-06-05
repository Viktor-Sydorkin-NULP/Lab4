package com.example.technical_task_service.controllers;

import com.example.technical_task_service.models.TechnicalTask;
import com.example.technical_task_service.services.TechnicalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technicalTasks")
public class TechnicalTaskController {

    @Autowired
    private TechnicalTaskService technicalTaskService;

    @PostMapping
    public void createTechnicalTask(@RequestBody TechnicalTask technicalTask) {
        technicalTaskService.createTechnicalTask(technicalTask);
    }
}

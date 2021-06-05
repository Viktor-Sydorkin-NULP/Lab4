package com.example.technical_task_service.models;

import lombok.Data;

@Data
public class Work {
    private long id;
    private int countOfWorkers;
    private String description;
}

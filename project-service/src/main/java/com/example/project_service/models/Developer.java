package com.example.project_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
    private long id;
    private String firstName;
    private String lastName;
    private int costPerHour;
    private int countOfHours;
}

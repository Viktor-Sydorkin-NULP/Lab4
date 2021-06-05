package com.example.bill_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private long id;
    private int daysDuration;
    private List<Developer> developerList;
    private String description;
}

package com.example.technical_task_service.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TechnicalTask{
    private long id;
    private List<Work> workList = new ArrayList<>();
}

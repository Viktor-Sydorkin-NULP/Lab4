package com.example.bill_service.services;

import com.example.bill_service.models.Bill;
import com.example.bill_service.models.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BillService {
    private final RestTemplate restTemplate;

    public Bill showBill(long projectId) {
        Project project = restTemplate.getForObject("http://PROJECT-SERVICE/projects/" + projectId, Project.class);
        long costOfProject = restTemplate.getForObject("http://PROJECT-SERVICE/projects/" + projectId + "/cost", long.class);

        return new Bill(costOfProject, project);
    }
}

package com.example.developer_service.services;

import com.example.developer_service.models.Developer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {
    private static List<Developer> developerList = new ArrayList<>();

    static {
        developerList.add(new Developer(1L, "Karl", "Brown", 10, 0));
        developerList.add(new Developer(2L, "Tom", "Black", 12,  0));
        developerList.add(new Developer(3L, "Ihor", "White", 8, 0));
    }

    public List<Developer> getAllDevelopers() {
        return developerList;
    }

    public void saveDeveloper(Developer developer) {
        developerList.add(developer);
    }

    public Developer findById(long id){
        return developerList.stream()
            .filter(dev -> dev.getId() == id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Developer not found!"));
    }

    public void deleteDeveloper(long id) {
        Developer developer = findById(id);
        developerList.remove(developer);
    }

    public void updateDeveloper(long id, Developer newDeveloper) {
        Developer oldDeveloper = findById(id);

        oldDeveloper.setFirstName(newDeveloper.getFirstName());
        oldDeveloper.setLastName(newDeveloper.getLastName());
        oldDeveloper.setCostPerHour(newDeveloper.getCostPerHour());
        oldDeveloper.setCountOfHours(newDeveloper.getCountOfHours());
    }

    public void logWork(long developerId, int hours) {
        Developer developer = findById(developerId);

        developer.setCountOfHours(developer.getCountOfHours() + hours);
    }
}

package com.example.bill_service.controllers;


import com.example.bill_service.models.Bill;
import com.example.bill_service.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/{projectId}")
    public Bill showBill(@PathVariable long projectId) {
        return billService.showBill(projectId);
    }
}

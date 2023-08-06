package com.example.mnog.service.controller;

import com.example.mnog.service.Service.DepartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departament")
public class DepartamentController {

    private final DepartService service;

    public DepartamentController(DepartService service) {
        this.service = service;
    }

    @GetMapping("/max_selary")
    public double max(@RequestParam int departmentId) {
return service.maxSelary(departmentId);
    }
}

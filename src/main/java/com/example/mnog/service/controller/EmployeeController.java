package com.example.mnog.service.controller;


import com.example.mnog.service.Employee;
import com.example.mnog.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        service.addEmployee(firstName, lastName, departament);
    }

    @GetMapping("/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        return service.findEmployee(firstName, lastName, departament);
    }

    @GetMapping("/remove")
    public boolean remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departament) {
        return service.removeEmployee(firstName, lastName, departament);
    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return service.getAll();
    }

}

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//    private final EmployeeService employeeService;
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//    @GetMapping("/add")
//    public Employee add(@RequestParam("firstName") String name,
//                        @RequestParam("lastName") String surname) {
//        return employeeService.addEmployee(name, surname);
//    }
//
//    @GetMapping("/remove")
//    public Employee remove(@RequestParam("firstName") String name,
//                           @RequestParam("lastName") String surname) {
//        return employeeService.removeEmployee (name, surname);
//    }
//
//    @GetMapping("/find")
//    public Employee find(@RequestParam("firstName") String name,
//                         @RequestParam("lastName") String surname) {
//        return employeeService.findEmployee(name, surname);
//    }
//
//    @GetMapping("/getAll")
//    public List<Employee> getAll() {
//        return employeeService.getAll();
//    }
//
//}
//}

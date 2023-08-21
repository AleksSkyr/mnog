package com.example.mnog.service.Service;

import com.example.mnog.service.Employee;
import com.example.mnog.service.exeption.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class DepartService {

    private final EmployeeService employeeService;

    public DepartService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public double maxSelary(int depId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == depId)
                .map(e -> e.getSalary())
                .max((Comparator.comparingDouble(o -> o)));
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public double minSelary(int depId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == depId)
                .map(e -> e.getSalary())
                .min((Comparator.comparingDouble(o -> o)));
                 .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findAllByDept(int deptId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartament() == deptId)
                .collect(Collectors.toList());

    }

public void groupByDepartment() {
      Map<Integer, List<Employee>> map = employeeService.getAll();
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartament));
}
}

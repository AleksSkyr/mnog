package com.example.mnog.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String,Employee> employee = new HashMap<>();

    public Employee add(String firstNaim) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(firstName,lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key,employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName,lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }
    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName,lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
    public String getKey (String firstName, String lastName){
        return firstName+lastName;
    }
}

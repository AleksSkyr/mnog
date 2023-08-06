package com.example.mnog.service;

import com.example.mnog.service.exeption.EmployeeAlreadyAddedException;
import com.example.mnog.service.exeption.EmployeeNotFoundException;
import com.example.mnog.service.exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();


    public void addEmployee(String firstName, String lastName, int departament) {
        if (employees.size() == LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        var employee = new Employee(firstName, lastName, departament);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    public Employee findEmployee(String firstName, String lastName, int departament) {
        var employee = new Employee(firstName, lastName, departament);
        for (Employee emp : employees) {
            if (emp.equals(employee)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public boolean removeEmployee(String firstName, String lastName, int departament) {
        var employee = new Employee(firstName, lastName, departament);
        if (employees.remove(employee)) {
            return true;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }
}

//@Service
//public class EmployeeService {
//    private static final int LIMIT = 10;
//    private final Map<String,Employee> employee = new HashMap<>();
//
//    public Employee add(String firstNaim) {
//        Employee employee = new Employee(firstName, lastName);
//        String key = getKey(firstName,lastName);
//        if (employees.containsKey(key)) {
//            throw new EmployeeAlreadyAddedException();
//        }
//        if (employees.size() < LIMIT) {
//            employees.put(key,employee);
//            return employee;
//        }
//        throw new EmployeeStorageIsFullException();
//    }
//
//    public Employee findEmployee(String firstName, String lastName) {
//        String key = getKey(firstName,lastName);
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.get(key);
//    }
//    public Employee removeEmployee(String firstName, String lastName) {
//        String key = getKey(firstName,lastName);
//        if (!employees.containsKey(key)) {
//            throw new EmployeeNotFoundException();
//        }
//        return employees.remove(key);
//    }
//
//    public List<Employee> getAll() {
//        return new ArrayList<>(employees.values());
//    }
//    public String getKey (String firstName, String lastName){
//        return firstName+lastName;
//    }
//}
